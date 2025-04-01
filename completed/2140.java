class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = Math.max(questions[i][0], dp[i + 1]);
            int nextIndex = i + questions[i][1] + 1;
            if (nextIndex < n) {
                dp[i] = Math.max(questions[i][0] + dp[nextIndex], dp[i]);
            }
        }
        return dp[0];
    }
}
