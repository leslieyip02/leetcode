import java.util.*;

class Solution {
    private boolean ok(int[] position, int m, int f) {
        int left = 0;
        int n = position.length;
        while (m > 1 && left < n) {
            int right = left + 1;
            while (right < n && position[right] - position[left] < f) {
                right++;
            }
            if (right == n) {
                return false;
            }
            left = right;
            m--;
        }
        return true;
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n - 1] - position[0];
        while (low < high) {
            int mid = (int) Math.ceil((low + high) / 2.0);
            if (ok(position, m, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
