class Solution {
    private boolean ok(int[] nums, int k, int mid) {
        int robbed = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                robbed++;
                i++;
            }
        }
        return robbed >= k;
    }

    public int minCapability(int[] nums, int k) {
        int lower = 0;
        int upper = 0;
        for (int num : nums) {
            upper = Math.max(num, upper);
        }

        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (ok(nums, k, mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }
}
