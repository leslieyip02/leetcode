import java.util.*;

class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] reachable = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            reachable[i][0] = true;
        }

        int furthest = 0;
        for (int col = 0; col < n - 1; col++) {
            for (int row = 0; row < m; row++) {
                if (!reachable[row][col]) {
                    continue;
                }

                if (row > 0 && grid[row - 1][col + 1] > grid[row][col]) {
                    reachable[row - 1][col + 1] = true;
                    furthest = Math.max(col + 1, furthest);
                }
                if (grid[row][col + 1] > grid[row][col]) {
                    reachable[row][col + 1] = true;
                    furthest = Math.max(col + 1, furthest);
                }
                if (row < m - 1 && grid[row + 1][col + 1] > grid[row][col]) {
                    reachable[row + 1][col + 1] = true;
                    furthest = Math.max(col + 1, furthest);
                }
            }
        }
        return furthest;
    }
}
