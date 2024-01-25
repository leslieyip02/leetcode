import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for (int i1 = 0; i1 < n1; i1++) {
            for (int i2 = 0; i2 < n2; i2++) {
                if (text1.charAt(i1) == text2.charAt(i2)) {
                    // must update diagonally because matching a character
                    // will cause the index of the subsequence to increase
                    if (i1 > 0 && i2 > 0) {
                        dp[i1][i2] = dp[i1 - 1][i2 - 1];
                    }
                    dp[i1][i2]++;
                } else {
                    if (i1 > 0) {
                        dp[i1][i2] = dp[i1 - 1][i2];
                    }
                    if (i2 > 0) {
                        dp[i1][i2] = Math.max(dp[i1][i2 - 1], dp[i1][i2]);
                    }
                }
            }
        }
        return dp[n1 - 1][n2 - 1];
    }
}
