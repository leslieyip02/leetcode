class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0;

        Queue<Integer[]> frontier = new ArrayDeque<>();
        frontier.add(new Integer[]{ 0, 0, 0 });
        while (!frontier.isEmpty()) {
            Integer[] current = frontier.poll();
            int i1 = current[0];
            int j1 = current[1];
            int c1 = current[2];
            int s1 = dp[i1][j1][c1];

            if (i1 < m - 1) {
                int i2 = i1 + 1;
                int j2 = j1;
                int c2 = c1 + (grid[i2][j2] == 0 ? 0 : 1);
                int s2 = s1 + grid[i2][j2];

                if (c2 <= k && s2 > dp[i2][j2][c2]) {
                    dp[i2][j2][c2] = s2;
                    frontier.add(new Integer[]{ i2, j2, c2 });
                }
            }
            if (j1 < n - 1) {
                int i3 = i1;
                int j3 = j1 + 1;
                int c3 = c1 + (grid[i3][j3] == 0 ? 0 : 1);
                int s3 = s1 + grid[i3][j3];

                if (c3 <= k && s3 > dp[i3][j3][c3]) {
                    dp[i3][j3][c3] = s3;
                    frontier.add(new Integer[]{ i3, j3, c3 });
                }
            }
        }

        int best = -1;
        for (int i = 0; i <= k; i++) {
            best = Math.max(dp[m - 1][n - 1][i], best);
        }
        return best;
    }
}
