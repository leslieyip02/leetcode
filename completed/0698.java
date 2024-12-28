import java.util.*;

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] kLengthSums = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            kLengthSums[0] += nums[i];
        }
        for (int i = 1; i < nums.length - k + 1; i++) {
            kLengthSums[i] = kLengthSums[i - 1] + nums[i + k - 1] - nums[i - 1];
        }

        int[][][] dp = new int[3][kLengthSums.length][4];
        dp[0][0][0] = kLengthSums[0];
        dp[0][0][1] = 0;
        for (int i = 1; i < kLengthSums.length; i++) {
            if (kLengthSums[i] > dp[0][i - 1][0]) {
                dp[0][i][0] = kLengthSums[i];
                dp[0][i][1] = i;
            } else {
                dp[0][i][0] = dp[0][i - 1][0];
                dp[0][i][1] = dp[0][i - 1][1];
            }
        }

        for (int chosen = 1; chosen < 3; chosen++) {
            for (int i = chosen * k; i < kLengthSums.length; i++) {
                for (int j = 0; j < 4; j++) {
                    dp[chosen][i][j] = dp[chosen][i - 1][j];
                }

                if (dp[chosen - 1][i - k][0] + kLengthSums[i] > dp[chosen][i - 1][0]) {
                    for (int j = 0; j < 4; j++) {
                        dp[chosen][i][j] = dp[chosen - 1][i - k][j];
                    }
                    dp[chosen][i][0] += kLengthSums[i];
                    dp[chosen][i][chosen + 1] = i;
                }
            }
        }

        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) {
            indices[i] = dp[2][kLengthSums.length - 1][i + 1];
        }
        return indices;
    }
}
