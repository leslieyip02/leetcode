class Solution {
    private static final int M = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        // any step further than steps / 2 doesn't matter
        // since the start cannot be reached
        int max = Math.min(steps / 2 + 1, arrLen);
        int[][] ways = new int[steps + 1][max];

        ways[0][0] = 1;
        for (int i = 1; i < steps + 1; i++) {
            for (int j = 0; j < max; j++) {
                ways[i][j] = ways[i - 1][j];
                if (j > 0) {
                    ways[i][j] += ways[i - 1][j - 1];
                    ways[i][j] %= Solution.M;
                }
                if (j < max - 1) {
                    ways[i][j] += ways[i - 1][j + 1];
                    ways[i][j] %= Solution.M;
                }
            }
        }
        return ways[steps][0];
    }

    public static void main(String[] args) {
        int steps = 3;
        int arrLen = 3;

        Solution solution = new Solution();
        System.out.println(solution.numWays(steps, arrLen));
    }
}
