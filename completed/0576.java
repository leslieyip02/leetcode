class Solution {
    private static final int M = (int) 1e9 + 7;

    private int paths(int m, int n, int[][] grid) {
        long total = 0;
        for (int i = 0; i < m; i++) {
            total += grid[i][0];
            total += grid[i][n - 1];
            total %= Solution.M;
        }
        for (int i = 0; i < n; i++) {
            total += grid[0][i];
            total += grid[m - 1][i];
            total %= Solution.M;
        }
        return (int) (total % Solution.M);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) {
            return 0;
        }
        int[][] dirs = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int[][] grid = new int[m][n];
        grid[startRow][startColumn] = 1;
        int total = this.paths(m, n, grid);
        for (int move = 1; move < maxMove; move++) {
            int[][] tmpGrid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] != 0) {
                        for (var dir : dirs) {
                            int a = i + dir[0];
                            int b = j + dir[1];
                            if (a >= 0 && a < m && b >= 0 && b < n) {
                                tmpGrid[a][b] += grid[i][j];
                                tmpGrid[a][b] %= Solution.M;
                            }
                        }
                    }
                }
            }
            grid = tmpGrid;
            total += this.paths(m, n, grid);
            total %= Solution.M;
        }
        return total;
    }
}
