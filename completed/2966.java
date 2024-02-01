import java.util.*;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        if (n % 3 != 0) {
            return new int[][] {};
        }

        n /= 3;
        Arrays.sort(nums);
        int[][] matrix = new int[n][3];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = nums[i * 3];
            for (int j = 1; j < 3; j++) {
                if (nums[i * 3 + j] - matrix[i][0] > k) {
                    return new int[][] {};
                }
                matrix[i][j] = nums[i * 3 + j];
            }
        }
        return matrix;
    }
}
