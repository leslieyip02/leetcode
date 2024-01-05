import java.util.*;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] indices = new int[nums.length + 1];
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            int lo = 1;
            int hi = length + 1;
            int mid = (lo + hi) / 2;
            while (lo < hi) {
                if (nums[indices[mid]] < nums[i]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
                mid = (lo + hi) / 2;
            }
            indices[mid] = i;
            length = Math.max(mid, length);
        }
        return length;
    }
}
