import java.util.*;

class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 1000);
        }
        dp[0][0] = 0;

        // i tracks length of string
        for (int i = 1; i <= n; i++) {
            // ii tracks number deleted
            for (int ii = 0; ii <= k; ii++) {
                int currentCount = 0;
                int deleteCount = 0;
                for (int iii = i; iii >= 1; iii--) {
                    // try to form one contiguous block from 0 to i
                    if (s.charAt(iii - 1) == s.charAt(i - 1)) {
                        currentCount++;
                    } else {
                        deleteCount++;
                    }

                    int iv = ii - deleteCount;
                    if (iv >= 0) {
                        int deleted = dp[iii - 1][iv] + 1;
                        if (currentCount > 1) {
                            deleted += 1 + (int) Math.log10(currentCount);
                        }
                        dp[i][ii] = Math.min(dp[i][ii], deleted);
                    }

                    // check if deleting at index i is better
                    if (ii > 0) {
                        dp[i][ii] = Math.min(dp[i][ii], dp[i - 1][ii - 1]);
                    }
                }
            }
        }
        return dp[n][k];
    }
}
