import java.util.*;

class Solution {
    public void wiggleSort(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = (int) Math.ceil(sorted.length / 2.0) - 1;
        int right = sorted.length - 1;
        for (int i = 0; i < sorted.length; i++) {
            if (i % 2 == 0) {
                nums[i] = sorted[left];
                left--;
            } else {
                nums[i] = sorted[right];
                right--;
            }
        }
    }
}
