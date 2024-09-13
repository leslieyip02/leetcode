import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{ 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 }};

    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> elements = new ArrayList<>();
        boolean[][] isVisited = new boolean[m][n];

        int x0 = 0;
        int y0 = 0;
        int i = 0;
        elements.add(matrix[y0][x0]);
        isVisited[y0][x0] = true;
        while (elements.size() < m * n) {
            int x1 = x0 + DIRECTIONS[i][0];
            int y1 = y0 + DIRECTIONS[i][1];
            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || isVisited[y1][x1])  {
                i = (i + 1) % DIRECTIONS.length;
                continue;
            }
            elements.add(matrix[y1][x1]);
            isVisited[y1][x1] = true;
            x0 = x1;
            y0 = y1;
        }
        return elements;
    }
}
