import java.util.*;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> minIndices = new Stack<>();
        minIndices.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[minIndices.peek()]) {
                minIndices.push(i);
            }
        }

        int width = 0;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (!minIndices.empty() && nums[minIndices.peek()] <= nums[j]) {
                int i = minIndices.pop();
                width = Math.max(j - i, width);
            }
        }
        return width;
    }
}
