import java.util.*;

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] suffixSums = new long[n];
        suffixSums[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + nums[i];
        }

        int valid = 0;
        for (int i = 0; i < n - 1; i++) {
            long right = suffixSums[i + 1];
            long left = suffixSums[0] - right;
            if (left >= right) {
                valid++;
            }
        }
        return valid;
    }
}
