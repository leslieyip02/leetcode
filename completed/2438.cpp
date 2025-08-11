class Solution {
private:
    const int M = 1e9 + 7;

    int exp(long long a, long long b) {
        long long c = 1;
        while (b > 0) {
            if (b & 1) {
                c = a * c % M;
            }
            a = a * a % M;
            b >>= 1;
        }
        return (int) c;
    }

public:
    vector<int> productQueries(int n, vector<vector<int>>& queries) {
        vector<int> shifts;
        int shift = 0;
        int mask = 1 << shift;
        while (shift <= 31 && mask <= n) {
            if (n & mask) {
                shifts.push_back(shift);
            }
            shift++;
            mask = 1 << shift;
        }

        vector<int> prefixSums(shifts.size() + 1);
        for (int i = 0; i < shifts.size(); i++) {
            prefixSums[i + 1] = shifts[i] + prefixSums[i];
        }

        vector<int> answers(queries.size());
        for (int i = 0; i < queries.size(); i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            answers[i] = exp(2, prefixSums[right + 1] - prefixSums[left]);
        }
        return answers;
    }
};
