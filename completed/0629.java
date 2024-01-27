class Solution {
    private static final int M = (int) 1e9 + 7;

    public int kInversePairs(int n, int k) {
        if (k == 0) {
            return 1;
        }

        int[][] dp = new int[n + 1][k + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // a sequence with k pairs of length i can be created from
                // a shorter sequence of length i - 1 containing k - d pairs
                // the next largest number i can be inserted at index i - 1 - d
                // because all numbers after this point are smaller than i,
                // which creates d more inverse pairs
                // the order is preserved and the front elements are unaffected
                // since i is larger than all of them
                for (int d = Math.min(i - 1, j); d >= 0; d--) {
                    dp[i][j] += dp[i - 1][j - d];
                    dp[i][j] %= Solution.M;
                }
            }
       }
       return dp[n][k];
    }
}
