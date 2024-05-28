import java.util.*;

class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs((int) s.charAt(i) - (int) t.charAt(i));
        }

        // sliding window
        int left = 0;
        int right = left;
        int current = 0;
        int best = 0;
        while (right < n) {
            while (left <= right && current + costs[right] > maxCost) {
                current -= costs[left];
                left++;
            }
            if (current + costs[right] <= maxCost) {
                current += costs[right];
            }
            best = Math.max(right - left + 1, best);
            right++;
        }
        return best;
    }
}
