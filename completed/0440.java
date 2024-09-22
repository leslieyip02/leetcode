import java.util.*;

class Solution {
    private int count(long prefix1, long prefix2, int max) {
        int steps = 0;
        while (prefix1 <= max) {
            steps += Math.min(max + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return steps;
    }

    public int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int steps = count(current, current + 1, n);
            if (steps <= k) {
                k -= steps;
                current++;
            } else {
                k--;
                current *= 10;
            }
        }
        return current;
    }
}
