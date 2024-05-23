import java.util.*;

class Solution {
    private int choose(int[] nums, int k, int current, Map<Integer, Integer> subset) {
        if (current == nums.length) {
            return 1;
        }

        int total = 0;
        int above = nums[current] - k;
        int below = nums[current] + k;
        // choose
        if (!subset.containsKey(above) && !subset.containsKey(below)) {
            subset.put(nums[current], subset.getOrDefault(nums[current], 0) + 1);
            total += choose(nums, k, current + 1, subset);
            subset.put(nums[current], subset.get(nums[current]) - 1);
            if (subset.get(nums[current]) == 0) {
                subset.remove(nums[current]);
            }
        }

        // don't choose
        total += choose(nums, k, current + 1, subset);
        return total;
    }

    public int beautifulSubsets(int[] nums, int k) {
        // -1 due to empty set
        return choose(nums, k, 0, new HashMap<>()) - 1;
    }
}
