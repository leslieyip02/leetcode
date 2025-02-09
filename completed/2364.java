import java.util.*;

class Solution {
    public long countBadPairs(int[] nums) {
        long n = nums.length;
        long maxPairs = n * (n - 1) / 2;

        Map<Integer, Integer> diffs = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int diff = i - nums[i];
            diffs.put(diff, diffs.getOrDefault(diff, 0) + 1);
        }

        long goodPairs = 0;
        for (int count : diffs.values()) {
            goodPairs += (long) count * (count - 1) / 2;
        }
        return maxPairs - goodPairs;
    }
}
