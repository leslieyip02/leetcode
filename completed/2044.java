import java.util.*;

class Solution {
    private int find(int[] nums, int index, int current, int maximum) {
        if (index == nums.length) {
            return 0;
        }

        int skip = find(nums, index + 1, current, maximum);
        current |= nums[index];
        int take = find(nums, index + 1, current, maximum);
        return skip + take + (current == maximum ? 1 : 0);
    }

    public int countMaxOrSubsets(int[] nums) {
        int maximum = 0;
        for (int num : nums) {
            maximum |= num;
        }
        return find(nums, 0, 0, maximum);
    }
}
