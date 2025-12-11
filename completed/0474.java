class Solution {

    private static int UNVISITED = -1;

    private int helper(int i, int[][] counts, int zeroes, int ones, int[][][] memo) {
        if (i == counts.length) {
            return 0;
        }

        if (memo[i][zeroes][ones] != UNVISITED) {
            return memo[i][zeroes][ones];
        }

        // skip
        int size = helper(i + 1, counts, zeroes, ones, memo);

        // pick
        if (counts[i][0] <= zeroes && counts[i][1] <= ones) {
            int next = helper(
                i + 1,
                counts,
                zeroes - counts[i][0],
                ones - counts[i][1],
                memo
            );
            size = Math.max(next + 1, size);
        }
        memo[i][zeroes][ones] = size;
        return size;
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                int k = strs[i].charAt(j) - '0';
                counts[i][k]++;
            }
        }

        int[][][] memo = new int[strs.length][m + 1][n + 1];
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[i].length; j++) {
                Arrays.fill(memo[i][j], UNVISITED);
            }
        }

        return helper(0, counts, m, n, memo);
    }
}
