import java.util.*;

class Solution {
    private boolean isMagic(int[][] grid, int r, int c) {
        Set<Integer> digits = new HashSet<>();
        int[] rowSums = new int[3];
        int[] colSums = new int[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[r + i][c + j] < 1 || grid[r + i][c + j] > 9) {
                    return false;
                }
                digits.add(grid[r + i][c + j]);

                rowSums[i] += grid[r + i][c + j];
                colSums[j] += grid[r + i][c + j];
            }
        }

        if (digits.size() != 9) {
            return false;
        }

        for (int i = 1; i < 3; i++) {
            if (rowSums[i] != rowSums[0] || colSums[i] != colSums[0]) {
                return false;
            }
        }

        int leftDiagonal = 0;
        int rightDiagonal = 0;
        for (int i = 0; i < 3; i++) {
            leftDiagonal += grid[r + i][c + i];
            rightDiagonal += grid[r + i][c + 2 - i];
        }
        return leftDiagonal == rightDiagonal;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;
        for (int r = 0; r < row - 2; r++) {
            for (int c = 0; c < col - 2; c++) {
                if (isMagic(grid, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }
}
