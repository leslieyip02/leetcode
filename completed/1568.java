import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 0, -1 }, { 1, 0 },  { -1 , 0 } };

    private void fill(int[][] grid, int i, int j, int n) {
        grid[i][j] = n;
        for (int[] direction : DIRECTIONS) {
            int a = i + direction[0];
            int b = j + direction[1];
            if (a < 0 || a >= grid.length || b < 0 || b >= grid[a].length) {
                continue;
            }

            if (grid[a][b] != 1) {
                continue;
            }
            fill(grid, a, b, n);
        }
    }

    private boolean isDisconnected(int[][] grid) {
        int n = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (n == 1) {
                        return true;
                    }

                    fill(grid, i, j, n + 2);
                    n++;
                }
            }
        }
        return n == 0;
    }

    public int minDays(int[][] grid) {
        int[][] copy = new int[grid.length][grid[0].length];
        for (int k = 0; k < grid.length; k++) {
            copy[k] = Arrays.copyOf(grid[k], grid[k].length);
        }
        if (isDisconnected(copy)) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }

                for (int k = 0; k < grid.length; k++) {
                    copy[k] = Arrays.copyOf(grid[k], grid[k].length);
                }
                copy[i][j] = 0;
                if (isDisconnected(copy)) {
                    return 1;
                }
            }
        }
        return 2;
    }
}
