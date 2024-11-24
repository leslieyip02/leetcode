import java.util.*;

class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int smallest = (int) 1e5;
        int negatives = 0;
        long sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += Math.abs(value);
                if (value < 0) {
                    negatives++;
                }
                smallest = Math.min(Math.abs(value), smallest);
            }
        }
        if (negatives % 2 == 1) {
            sum -= 2 * smallest;
        }
        return sum;
    }
}
