import java.util.*;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            sum = Math.max(nums[i] + nums[n - 1 - i], sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 4, 2, 4, 6 };

        Solution solution = new Solution();
        System.out.println(solution.minPairSum(nums));
    }
}
