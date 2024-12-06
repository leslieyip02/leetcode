import java.util.*;

class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int num : banned) {
            set.add(num);
        }

        int sum = 0;
        int added = 0;
        for (int i = 1; i <= n; i++) {
            if (set.contains(i)) {
                continue;
            }

            sum += i;
            if (sum > maxSum) {
                break;
            }
            added++;
        }
        return added;
    }
}
