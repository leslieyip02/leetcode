class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d > n) {
            return -1;
        }

        int[][] dp = new int[d][n];
        dp[0][0] = jobDifficulty[0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], jobDifficulty[i]);
        }
        for (int i = 1; i < d; i++) {
            for (int j = i; j < n; j++) {
                int max = jobDifficulty[j];
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = j; k >= i; k--) {
                    max = Math.max(jobDifficulty[k], max);
                    dp[i][j] = Math.min(dp[i - 1][k - 1] + max, dp[i][j]);
                }
            }
        }
        return dp[d - 1][n - 1];
    }

    public static void main(String[] args) {
        int[] jobDifficulty = new int[] { 11, 111, 22, 222, 33, 333, 44, 444 };
        int d = 6;

        Solution solution = new Solution();
        System.out.println(solution.minDifficulty(jobDifficulty, d));
    }
}
