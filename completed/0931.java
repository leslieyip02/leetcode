class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int m = 100 * 100;
                for (int k = -1; k <= 1; k++) {
                    if (j + k < 0 || j + k >= matrix[i].length) {
                        continue;
                    }
                    m = Math.min(matrix[i - 1][j + k], m);
                }
                matrix[i][j] += m;
            }
        }
        int s = 100 * 100;
        for (int i : matrix[matrix.length - 1]) {
            s = Math.min(i, s);
        }
        return s;
    }
}
