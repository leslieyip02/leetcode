class Solution {
private:
    void add(int current, int n, vector<int> &result) {
        int start = current == 0 ? 1 : 0;
        for (int i = start; i <= 9; i++) {
            int next = current * 10 + i;
            if (next > n) {
                break;
            }
            result.push_back(next);
            add(next, n, result);
        }
    }

public:
    vector<int> lexicalOrder(int n) {
        vector<int> result;
        add(0, n, result);
        return result;
    }
};
