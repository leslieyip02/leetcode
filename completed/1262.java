class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length][3];
        dp[0][nums[0] % 3] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            for (int j = 0; j < 3; j++) {
                int sum = dp[i - 1][j] + nums[i];
                dp[i][sum % 3] = Math.max(sum, dp[i][sum % 3]);
            }
        }
        return dp[nums.length - 1][0];
    }
}
