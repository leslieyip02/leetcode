import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    private int split(int[] prefixSums, int left) {
        int leftSum = prefixSums[left];
        int total = prefixSums[prefixSums.length - 1];

        int start = left + 1;
        int end = prefixSums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int midSum = prefixSums[mid] - leftSum;
            if (midSum < leftSum) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int leftmost = start;

        end = prefixSums.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            int midSum = prefixSums[mid] - leftSum;
            int rightSum = total - prefixSums[mid];
            if (midSum > rightSum) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        int rightmost = start - 1;
        return Math.max(rightmost - leftmost + 1, 0);
    }

    public int waysToSplit(int[] nums) {
        int[] prefixSums = new int[nums.length];
        prefixSums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }

        int ways = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            ways = ways + split(prefixSums, i);
            ways %= M;
        }
        return ways;
    }
}
