import java.util.*;

class Solution {
    private int bits(int num) {
        int count = 0;
        while (num > 0) {
           if ((num & 1) != 0) {
                count++;
           }
           num >>= 1;
        }
        return count;
    }

    public boolean canSortArray(int[] nums) {
        int previousMax = 0;
        int currentMax = nums[0];
        int currentBits = bits(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int b = bits(nums[i]);
            if (nums[i] < previousMax) {
                return false;
            }

            if (b == currentBits) {
                currentMax = Math.max(currentMax, nums[i]);
            } else {
                if (nums[i] < currentMax) {
                    return false;
                }
                previousMax = currentMax;
                currentMax = nums[i];
                currentBits = b;
            }
        }
        return true;
    }
}
