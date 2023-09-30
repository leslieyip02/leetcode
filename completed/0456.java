import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int k = (int) -1e9;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                k = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        // int[] nums = { -1, 3, 2, 0 };
        // int[] nums = { 1, 0, 1, -4, -3 };

        Solution solution = new Solution();
        System.out.println(solution.find132pattern(nums));
    }
}
