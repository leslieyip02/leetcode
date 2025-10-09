class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k + 1][prices.length];
        for (int i = 1; i <= k; i++) {
            int gain = dp[i - 1][0] - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(prices[j] + gain, dp[i][j - 1]);
                gain = Math.max(dp[i - 1][j] - prices[j], gain);
            }
        }
        return dp[k][prices.length - 1];
    }
}
