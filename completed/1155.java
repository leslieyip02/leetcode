import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n][target];
        for (int i = 0; i < k && i < target; i++) {
            dp[0][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i; j < target && dp[i][j] != 0; j++) {
                for (int p = 1; p <= k && j + p < target; p++) {
                    dp[i + 1][j + p] += dp[i][j];
                    dp[i + 1][j + p] %= Solution.M;
                }
            }
        }
        return dp[n - 1][target - 1];
    }
}
