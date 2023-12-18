import java.util.*;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int a = nums[nums.length - 1];
        int b = nums[nums.length - 2];
        int c = nums[0];
        int d = nums[1];
        return a * b - c * d;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 5, 9, 7, 4, 8 };

        Solution solution = new Solution();
        System.out.println(solution.maxProductDifference(nums));
    }
}
