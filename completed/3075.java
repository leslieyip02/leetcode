import java.util.*;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long m = 0;
        int n = happiness.length;
        for (int i = 0; i < k; i++) {
            m += Math.max(happiness[n - 1 - i] - i, 0);
        }
        return m;
    }
}
