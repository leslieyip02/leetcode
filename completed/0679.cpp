class Solution {
private:
    bool backtrack(vector<double>& cards) {
        if (cards.size() == 1) {
            return abs(cards[0] - 24.0) < 1e-5;
        }

        for (int i = 0; i < cards.size() - 1; i++) {
            double a = cards[i];

            for (int j = i + 1; j < cards.size(); j++) {
                double b = cards[j];

                vector<double> options = { a + b, a - b, b - a, a * b };
                if (a != 0) {
                    options.push_back(b / a);
                }
                if (b != 0) {
                    options.push_back(a / b);
                }

                for (double option : options) {
                    vector<double> copied = { option };
                    for (int k = 0; k < cards.size(); k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        copied.push_back(cards[k]);
                    }
                    if (backtrack(copied)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

public:
    bool judgePoint24(vector<int>& cards) {
        vector<double> copied;
        for (int card : cards) {
            copied.push_back(card);
        }
        return backtrack(copied);
    }
};
