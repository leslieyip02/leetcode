import java.util.*;

class Solution {
    public int validSubarraySize(int[] nums, int threshold) {
        int[] lefts = new int[nums.length];
        // monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            lefts[i] = i;
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                lefts[i] = lefts[stack.pop()];
            }
            stack.push(i);
        }

        int[] rights = new int[nums.length];
        // monotonic decreasing stack
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            rights[i] = i;
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                rights[i] = rights[stack.pop()];
            }
            stack.push(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int k = rights[i] - lefts[i] + 1;
            if (nums[i] > threshold / k) {
                return k;
            }
        }
        return -1;
    }
}
