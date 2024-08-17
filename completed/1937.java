import java.util.*;

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] dp = new long[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = points[0][i];
        }

        for (int i = 1; i < m; i++) {
            long[] leftMax = new long[n];
            leftMax[0] = dp[i - 1][0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, dp[i - 1][j]);
            }

            long[] rightMax = new long[n];
            rightMax[n - 1] = dp[i - 1][n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, dp[i - 1][j]);
            }

            for (int j = 0; j < n; j++) {
                dp[i][j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }
        }

        long best = 0;
        for (int i = 0; i < n; i++) {
            best = Math.max(dp[m - 1][i], best);
        }
        return best;
    }
}
