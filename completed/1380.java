import java.util.*;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] minimums = new int[m];
        int[] maximums = new int[n];
        Arrays.fill(minimums, (int) 1e5);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minimums[i] = Math.min(matrix[i][j], minimums[i]);
                maximums[j] = Math.max(matrix[i][j], maximums[j]);
            }
        }

        List<Integer> lucky = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == minimums[i] && matrix[i][j] == maximums[j]) {
                    lucky.add(matrix[i][j]);
                }
            }
        }
        return lucky;
    }
}
