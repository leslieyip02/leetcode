import java.util.*;

class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] result = new int[nums.length];
        int x = 0;
        int y = nums.length - 1;
        for (int num : nums) {
            if (num % 2 == 0) {
                result[x] = num;
                x++;
            } else {
                result[y] = num;
                y--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };

        Solution solution = new Solution();
        int[] result = solution.sortArrayByParity(nums);
        for (int num : result) {
            System.out.print(String.format("%d ", num));
        }
        System.out.println();
    }
}
