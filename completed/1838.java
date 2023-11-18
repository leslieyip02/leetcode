import java.util.*;

class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            int n = k;
            int f = 1;
            for (; f >= 0 && i - f >= 0; f++) {
                int d = nums[i] - nums[i - f];
                if (d > n) {
                    break;
                } else {
                    n -= d;
                }
            }
            max = Math.max(f, max);
        }
        return max; 
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 8, 13 };
        int k = 5;

        Solution solution = new Solution();
        System.out.println(solution.maxFrequency(nums, k));
    }
}
