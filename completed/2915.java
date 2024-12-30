import java.util.*;

class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int[][] dp = new int[nums.size()][target + 1];
        for (int i = 0; i < nums.size(); i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) <= target) {
                dp[i][nums.get(i)] = Math.max(1, dp[i][nums.get(i)]);
            }

            if (i == 0) {
                continue;
            }

            for (int j = 0; j <= target; j++) {
                if (dp[i - 1][j] == -1) {
                    continue;
                }
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);

                int next = j + nums.get(i);
                if (next > target) {
                    continue;
                }
                if (dp[i - 1][j] + 1 > dp[i][next]) {
                    dp[i][next] = dp[i - 1][j] + 1;
                }
            }
        }
        return dp[nums.size() - 1][target];
    }
}
