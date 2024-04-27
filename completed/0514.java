import java.util.*;

class Solution {
    private static final int INF = (int) 1e9;

    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int k = key.length();
        int[][] adjL = new int[n][26];
        int[][] adjR = new int[n][26];
        int[][] dp = new int[k][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(adjL[i], INF);
            Arrays.fill(adjR[i], INF);

            for (int j = 0; j <= n / 2; j++) {
                int l = (i + n - j) % n;
                int index = ring.charAt(l) - 97;
                if (j < adjL[i][index]) {
                    adjL[i][index] = j;
                }

                int r = (i + j) % n;
                index = ring.charAt(r) - 97;
                if (j < adjR[i][index]) {
                    adjR[i][index] = j;
                }
            }

            dp[0][i] = INF;
            if (ring.charAt(i) == key.charAt(0)) {
                dp[0][i] = i <= n / 2 ? i : n - i;
            }
        }

        for (int i = 0; i < k - 1; i++) {
            Arrays.fill(dp[i + 1], INF);
            Arrays.fill(dp[i + 1], INF);

            int target = key.charAt(i + 1) - 97;
            for (int j = 0; j < n; j++) {
                if (ring.charAt(j) == key.charAt(i)) {
                    int d = adjL[j][target];
                    // negative weight
                    if (d != INF) {
                        int next = (j + n - d) % n;
                        if (dp[i][j] + d < dp[i + 1][next]) {
                            dp[i + 1][next] = dp[i][j] + d;
                        }
                    }

                    d = adjR[j][target];
                    if (d != INF) {
                        int next = (j + n + d) % n;
                        if (dp[i][j] + d < dp[i + 1][next]) {
                            dp[i + 1][next] = dp[i][j] + d;
                        }
                    }
                }
            }
        }

        int result = INF;
        for (int i = 0; i < n; i++) {
            if (dp[k - 1][i] < result) {
                result = dp[k - 1][i];
            }
        }
        return result + k;
    }
}
