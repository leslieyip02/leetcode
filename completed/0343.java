class Solution {
    private int[] dp;

    private int split(int n) {
        if (this.dp[n] != 0) {
            return Math.max(this.dp[n], n);
        }

        int p = 0;
        for (int i = 1; i <= n / 2; i++) {
            int q = split(i) * split(n - i);
            if (q > p) {
                p = q;
            }
        }
        this.dp[n] = p;
        return p;
    }

    public int integerBreak(int n) {
        this.dp = new int[n + 1];
        this.dp[1] = 1;
        this.dp[2] = 1;
        return this.dp[n] == 0 ? split(n) : this.dp[n];
    }

    public static void main(String[] args) {
        int n = 10;

        Solution solution = new Solution();
        System.out.println(solution.integerBreak(n));
    }
}
