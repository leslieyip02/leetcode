import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{ { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    private void flood(int[][] grid2, int[][] grid3, int row, int col, int current) {
        grid3[row][col] = current;
        for (int[] direction : DIRECTIONS) {
            int dx = direction[0];
            int dy = direction[1];
            if (row + dy < 0 || row + dy >= grid2.length ||
                col + dx < 0 || col + dx >= grid2[0].length) {
                continue;
            }

            if (grid2[row + dy][col + dx] == 1 && grid3[row + dy][col + dx] == 0) {
                grid3[row + dy][col + dx] = current;
                flood(grid2, grid3, row + dy, col + dx, current);
            }
        }
    }

    private boolean find(int[][] grid1, int[][] grid3, boolean[][] visited, int row, int col) {
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            int dx = direction[0];
            int dy = direction[1];
            if (row + dy < 0 || row + dy >= grid1.length ||
                col + dx < 0 || col + dx >= grid1[0].length) {
                continue;
            }

            if (visited[row + dy][col + dx]) {
                continue;
            }

            if (grid3[row + dy][col + dx] == grid3[row][col]) {
                if (grid1[row + dy][col + dx] != 1) {
                    return false;
                }
                if (!find(grid1, grid3, visited, row + dy, col + dx)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;

        int[][] grid3 = new int[m][n];
        int current = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] != 1 || grid3[i][j] != 0) {
                    continue;
                }
                flood(grid2, grid3, i, j, current);
                current++;
            }
        }

        Map<Integer, Boolean> islands = new HashMap<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] || grid3[i][j] == 0) {
                    continue;
                }

                if (grid1[i][j] != 1) {
                    islands.put(grid3[i][j], false);
                }

                if (find(grid1, grid3, visited, i, j)) {
                    islands.put(grid3[i][j], !islands.containsKey(grid3[i][j]));
                }
            }
        }
        int count = 0;
        for (Boolean ok : islands.values()) {
            if (ok) {
                count++;
            }
        }
        return count;
    }
}
