class Solution {
public:
    int maxCollectedFruits(vector<vector<int>>& fruits) {
        int n = fruits.size();
        vector<vector<int>> dp(n, vector<int>(n));
        dp[0][n - 1] = fruits[0][n - 1];
        dp[n - 1][0] = fruits[n - 1][0];
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j >= n - 1 - i; j--) {
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k >= n || j + k <= i + 1) {
                        continue;
                    }

                    dp[i + 1][j + k] = max(
                        dp[i][j] + fruits[i + 1][j + k],
                        dp[i + 1][j + k]
                    );
                    dp[j + k][i + 1] = max(
                        dp[j][i] + fruits[j + k][i + 1],
                        dp[j + k][i + 1]
                    );
                }
            }
        }

        int child1 = 0;
        for (int i = 0; i < n; i++) {
            child1 += fruits[i][i];
        }

        int child2 = dp[n - 2][n - 1];
        int child3 = dp[n - 1][n - 2];
        return child1 + child2 + child3;
    }
};
