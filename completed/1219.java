import java.util.*;

class Solution {
    private final static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int search(int[][] grid, boolean[][] visited, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        int most = 0;
        visited[row][col] = true;
        for (var dir : dirs) {
            int i = row + dir[0];
            int j = col + dir[1];
            if (i < 0 || i >= m || j < 0 || j >= n) {
                continue;
            }

            if (grid[i][j] == 0 || visited[i][j]) {
                continue;
            }

            most = Math.max(search(grid, visited, i, j), most);
        }
        visited[row][col] = false;
        return grid[row][col] + most;
    }

    public int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int most = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                most = Math.max(search(grid, visited, i, j), most);
            }
        }
        return most;
    }
}
