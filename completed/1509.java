import java.util.*;

class Solution {
    private int difference(int[] nums, int moves) {
        int left = (moves & 1) + (moves & 2);
        int right = nums.length - 1 - (1 - (moves & 1)) - (2 - (moves & 2));
        return nums[right] - nums[left];
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }

        // brute force since low number of moves
        Arrays.sort(nums);
        int minimum = nums[nums.length - 1] - nums[0];
        for (int i = 0; i < 4; i++) {
            minimum = Math.min(difference(nums, i), minimum);
        }
        return minimum;
    }
}
