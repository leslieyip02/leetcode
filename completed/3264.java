import java.util.*;

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> indices = new PriorityQueue<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        for (int i = 0; i < nums.length; i++) {
            indices.add(i);
        }
        for (int i = 0; i < k; i++) {
            int index = indices.poll();
            nums[index] *= multiplier;
            indices.add(index);
        }
        return nums;
    }
}
