import java.util.*;

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int sum = 0;
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(
                    dp[i][j + 1],
                    Math.min(dp[i + 1][j], dp[i][j])
                ) + 1;
                sum += dp[i + 1][j + 1];
            }
        }
        return sum;
    }
}
