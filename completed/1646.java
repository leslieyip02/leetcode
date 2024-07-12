class Solution {
    public int getMaximumGenerated(int n) {
        if (n <= 1) {
            return n;
        }

        int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        int maximum = 0;
        for (int i = 2; i < nums.length; i++) {
            nums[i] = i % 2 == 0 ? nums[i / 2] : nums[i / 2] + nums[i / 2 + 1];
            maximum = Math.max(nums[i], maximum);
        }
        return maximum;
    }
}
