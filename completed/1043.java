class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        for (int i = 1; i < arr.length + 1; i++) {
            int max = -1;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                max = Math.max(arr[i - j], max);
                dp[i] = Math.max(dp[i - j] + max * j, dp[i]);
            }
        }
        return dp[arr.length];
    }
}
