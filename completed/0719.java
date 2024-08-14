import java.util.*;

class Solution {
    private static final int N = (int) 1e6;

    public int smallestDistancePair(int[] nums,  int k) {
        int[] buckets = new int[N + 1];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                buckets[diff]++;
            }
        }

        int diff = 0;
        while (k > 0) {
            if (buckets[diff] >= k) {
                return diff;
            }
            k -= buckets[diff];
            diff++;
        }
        return N;
    }
}
