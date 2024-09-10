import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);

        int[] modularPow2 = new int[nums.length];
        modularPow2[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            modularPow2[i] = (modularPow2[i - 1] << 1) % M;
        }

        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // left is min, right is max since nums is sorted
            if (nums[left] + nums[right] <= target) {
                // left and right must be picked,
                // so the (right - left) elements
                // in between can either be picked or not picked
                count += modularPow2[right - left];
                count %= M;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
