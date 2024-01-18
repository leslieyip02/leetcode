class Solution {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }

        int[] ways = new int[n];
        ways[0] = 1;
        ways[1] = 2;
        for (int i = 2; i < n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[n - 1];
    }
}
