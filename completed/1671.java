import java.util.*;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int[] lis = new int[nums.length];
        int[] dp = new int[nums.length + 1];
        int longestIncreasing = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = 1;
            int high = longestIncreasing + 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (nums[dp[mid]] >= nums[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            dp[low] = i;
            longestIncreasing = Math.max(low, longestIncreasing);
            lis[i] = longestIncreasing;
        }

        int[] lds = new int[nums.length];
        int longestDecreasing = 0;
        Arrays.fill(dp, 0);
        for (int i = nums.length - 1; i >= 0; i--) {
            int low = 1;
            int high = longestDecreasing + 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (nums[dp[mid]] >= nums[i]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            dp[low] = i;
            longestDecreasing = Math.max(low, longestDecreasing);
            lds[i] = longestDecreasing;
        }

        int minimum = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (lis[i] < 2 || lds[i] < 2) {
                continue;
            }
            minimum = Math.min(nums.length - lis[i] - lds[i] + 1, minimum);
        }
        return minimum;
    }
}
