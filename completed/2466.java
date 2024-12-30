import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 0; i <= high; i++) {
            if (i + zero <= high) {
                dp[i + zero] = (dp[i + zero] + dp[i]) % M;
            }
            if (i + one <= high) {
                dp[i + one] = (dp[i + one] + dp[i]) % M;
            }
        }

        int count = 0;
        for (int i = low; i <= high; i++) {
            count = (count + dp[i]) % M;
        }
        return count;
    }
}
