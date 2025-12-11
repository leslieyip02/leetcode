class Solution {

    private int helper(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        for (int i = 1; i <= n; i++) {
            dp[n] += helper(i - 1, dp) * helper(n - i, dp);
        }
        return dp[n];
    }

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return helper(n, dp);
    }
}
