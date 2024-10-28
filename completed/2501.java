import java.util.*;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Long> set = new HashSet<>();
        for (int num : nums) {
            set.add((long) num);
        }

        int longest = -1;
        for (int num : nums) {
            int length = 1;
            long current = (long) num * num;
            while (set.contains(current)) {
                length++;
                current *= current;
            }
            if (length > 1) {
                longest = Math.max(length, longest);
            }
        }
        return longest;
    }
}
