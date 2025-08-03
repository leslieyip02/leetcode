class Solution {
public:
    int maxTotalFruits(vector<vector<int>>& fruits, int startPos, int k) {
        vector<int> sums(2e5 + 1);
        int furthest = 0;
        for (vector<int>& fruit : fruits) {
            int position = fruit[0];
            int amount = fruit[1];
            sums[position] = amount;
            furthest = max(position, furthest);
        }
        sums.resize(furthest + 1);

        for (int i = startPos - 2; i >= 0; i--) {
            sums[i] += sums[i + 1];
        }
        for (int i = startPos + 1; i < sums.size(); i++) {
            sums[i] += sums[i - 1];
        }

        int maxTotal = sums[startPos];
        for (int i = 1; i <= k; i++) {
            if (startPos - i < 0) {
                break;
            }
            if (startPos - i >= sums.size()) {
                continue;
            }

            int total = sums[startPos - i];
            int mirrored = startPos + (k - i * 2);
            if (mirrored >= startPos) {
                total += sums[min(mirrored, (int) sums.size() - 1)];
            } else {
                total += sums[startPos];
            }
            maxTotal = max(total, maxTotal);
        }
        for (int i = 1; i <= k; i++) {
            if (startPos + i >= sums.size()) {
                break;
            }

            int total = sums[startPos + i];
            int mirrored = startPos - (k - i * 2);
            if (mirrored < startPos) {
                total += sums[max(mirrored, 0)];
            }
            maxTotal = max(total, maxTotal);
        }
        return maxTotal;
    }
};

