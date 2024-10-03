import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
            sum %= p;
        }

        int remainder = sum; 
        if (remainder == 0) {
            return 0;
        }

        Map<Integer, Integer> indices = new HashMap<>();
        indices.put(0, -1);
        int minimum = nums.length;
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            current %= p;

            int target = (current - remainder + p) % p;
            if (indices.containsKey(target)) {
                minimum = Math.min(i - indices.get(target), minimum);
            }

            indices.put(current, i);
        }
        return minimum == nums.length ? -1 : minimum;
    }
}
