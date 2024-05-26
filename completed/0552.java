import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int checkRecord(int n) {
        // row is number of absences
        // col is number of consecutive late days
        int[][] dp = new int[2][3];
        dp[0][0] = dp[0][1] = dp[1][0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                int l = (dp[j][1] + dp[j][2]) % M;
                dp[j][2] = dp[j][1];
                dp[j][1] = dp[j][0];
                dp[j][0] = (dp[j][0] + l) % M;
            }
            dp[1][0] = (dp[1][0] + dp[0][0]) % M;
        }

        int result = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result = (result + dp[i][j]) % M;
            }
        }
        return result;
    }
}
