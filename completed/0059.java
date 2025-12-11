class Solution {

    private static final int[][] DIRECTIONS = new int[][]{
        { 1, 0 },
        { 0, 1 },
        { -1, 0 },
        { 0, -1 },
    };

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int x0 = 0;
        int y0 = 0;
        int current = 0;
        for (int i = 1; i < n * n; i++) {
            matrix[y0][x0] = i;

            int dx = DIRECTIONS[current][0];
            int dy = DIRECTIONS[current][1];
            int x1 = x0 + dx;
            int y1 = y0 + dy;
            while (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n || matrix[y1][x1] != 0) {
                current = (current + 1) % DIRECTIONS.length;

                dx = DIRECTIONS[current][0];
                dy = DIRECTIONS[current][1];
                x1 = x0 + dx;
                y1 = y0 + dy;
            }

            x0 = x1;
            y0 = y1;
        }
        matrix[y0][x0] = n * n;

        return matrix;
    }
}
