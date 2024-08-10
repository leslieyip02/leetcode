import java.util.*;

class Solution {
    private static final int EMPTY = 0;
    private static final int SLASH = -1;
    private static final int[][] DIRECTIONS = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void fill(int[][] regions, int i, int j, int n) {
        regions[i][j] = n;

        for (int[] direction : DIRECTIONS) {
            int a = i + direction[0];
            int b = j + direction[1];
            if (a < 0 || a >= regions.length || b < 0 || b >= regions[a].length) {
                continue;
            }

            if (regions[a][b] != EMPTY) {
                continue;
            }

            fill(regions, a, b, n);
        }
    }

    public int regionsBySlashes(String[] grid) {
        int height = grid.length;
        int width = grid[0].length();

        int[][] regions = new int[height * 3][width * 3];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i].charAt(j) == '/') {
                    regions[i * 3][j * 3 + 2] = SLASH;
                    regions[i * 3 + 1][j * 3 + 1] = SLASH;
                    regions[i * 3 + 2][j * 3] = SLASH;
                } else if (grid[i].charAt(j) == '\\') {
                    regions[i * 3][j * 3] = SLASH;
                    regions[i * 3 + 1][j * 3 + 1] = SLASH;
                    regions[i * 3 + 2][j * 3 + 2] = SLASH;
                }
            }
        }

        int n = 0;
        for (int i = 0; i < regions.length; i++) {
            for (int j = 0; j < regions[i].length; j++) {
                if (regions[i][j] == EMPTY) {
                    n++;
                    fill(regions, i, j, n);
                }
            }
        }
        return n;
    }
}
