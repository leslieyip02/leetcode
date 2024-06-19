import java.util.*;

class Solution {
    private boolean makeBouquet(int[] bloomDay, int m, int k, int n) {
        int left = 0;
        int right = 0;
        while (m > 0 && right < bloomDay.length) {
            if (bloomDay[right] <= n) {
                if (right - left + 1 == k) {
                    m--;
                    left = right + 1;
                }
            } else {
                left = right + 1;
            }
            right++;
        }
        return m == 0;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = (int) 1e9;
        int mid = (low + high) / 2;
        while (low < high) {
            if (makeBouquet(bloomDay, m, k, mid)) {
                high = mid; 
            } else {
                low = mid + 1;
            }
            mid = (low + high) / 2;
        }
        return makeBouquet(bloomDay, m, k, mid) ? mid : -1;
    }
}
