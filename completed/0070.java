class Solution {
    private int[] memo;

    private int climb(int n) {
        if (memo[n] == 0) {
            memo[n] = climb(n - 1) + climb(n - 2);
        }
        return memo[n];
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        this.memo = new int[n + 1];
        this.memo[1] = 1;
        this.memo[2] = 2;
        return climb(n);
    }

    public static void main(String[] args) {
        int n = 4;

        Solution solution = new Solution();
        System.out.println(solution.climbStairs(n));
    }
}
