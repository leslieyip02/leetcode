class Solution {
public:
    int countSquares(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();
        vector<vector<int>> dp(m + 1, vector<int>(n + 1));

        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (!matrix[r][c]) {
                    continue;
                }

                dp[r + 1][c + 1] = min(dp[r][c], min(dp[r + 1][c], dp[r][c + 1])) + 1;
                count += dp[r + 1][c + 1];
            }
        }
        return count;
    }
};
