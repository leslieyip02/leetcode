import java.util.*;

class Solution {
    private static final int RIGHT = 0;
    private static final int DOWN = 1;
    private static final int LEFT = 2;
    private static final int UP = 3;

    private List<Integer[]> go(int rows, int cols, int r, int c, int n, int direction, int length) {
        List<Integer[]> visited = new ArrayList<>();
        if (direction % 2 == 0) {
            if (r >= 0 && r < rows) {
                for (int i = 0; i < length - 1; i++) {
                    int k = c + i * (direction == RIGHT ? 1 : -1);
                    if (k < 0 || k >= cols) {
                        continue;
                    }
                    visited.add(new Integer[] { r, k });
                    n++;
                }
            }
            c += (length - 1) * (direction == RIGHT ? 1 : -1);
        } else {
            if (c >= 0 && c < cols) {
                for (int i = 0; i < length - 1; i++) {
                    int k = r + i * (direction == DOWN ? 1 : -1);
                    if (k < 0 || k >= rows) {
                        continue;
                    }
                    visited.add(new Integer[] { k, c });
                    n++;
                }
            }
            r += (length - 1) * (direction == DOWN ? 1 : -1);
            length++;
        }

        int total = rows * cols;
        if (n <= total) {
            visited.addAll(go(rows, cols, r, c, n, (direction + 1) % 4, length));
        }
        return visited;
    }

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<Integer[]> visited = go(rows, cols, rStart, cStart, 1, RIGHT, 2);
        int[][] result = new int[rows * cols][2];
        for (int i = 0; i < rows * cols; i++) {
            result[i][0] = visited.get(i)[0];
            result[i][1] = visited.get(i)[1];
        }
        return result;
    }
}
