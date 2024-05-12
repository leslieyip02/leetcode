import java.util.*;

class Solution {
    private int maxInWindow(int[][] grid, int row, int col) {
        int max = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                max = Math.max(grid[row + i][col + j], max);
            }
        }
        return max;
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] maxLocal = new int[n - 2][n - 2];
        for (int row = 0; row < n - 2; row++) {
            for (int col = 0; col < n - 2; col++) {
                maxLocal[row][col] = maxInWindow(grid, row, col);
            }
        }
        return maxLocal;
    }
}
