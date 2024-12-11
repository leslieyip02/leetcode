import java.util.*;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        Queue<Integer> withinRange = new LinkedList<>();
        withinRange.add(nums[0]);
        int beauty = 1;
        for (int i = 1; i < nums.length; i++) {
            withinRange.add(nums[i]);
            while (withinRange.peek() + k * 2 < nums[i]) {
                withinRange.poll();
            }
            beauty = Math.max(withinRange.size(), beauty);
        }
        return beauty;
    }
}
