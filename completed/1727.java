import java.util.*;

class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int largest = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                // sum consecutive 1s
                if (matrix[i][j] == 1 && i > 0 && matrix[i - 1][j] > 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }

            int[] current = matrix[i].clone();
            Arrays.sort(current);
            for (int j = 0; j < current.length; j++) {
                // form matrix with height of current[j]
                // and width of everything else after
                // since everything after current[j] is larger or equal
                int size = current[j] * (current.length - j);
                largest = Math.max(size, largest);
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };

        Solution solution = new Solution();
        System.out.println(solution.largestSubmatrix(matrix));
    }
}
