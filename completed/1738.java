import java.util.*;

class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] values = new int[m][n];
        PriorityQueue<Integer> largest = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                values[i][j] = matrix[i][j];
                if (i > 0) {
                    values[i][j] ^= values[i - 1][j];
                }
                if (j > 0) {
                    values[i][j] ^= values[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    values[i][j] ^= values[i - 1][j - 1];
                }
                largest.add(values[i][j]);
            }
        } 

        for (int i = 0; i < k - 1; i++) {
            largest.poll();
        }
        return largest.poll();
    }
}
