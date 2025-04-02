class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] suffixMaxes = new int[n];
        suffixMaxes[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMaxes[i] = Math.max(nums[i], suffixMaxes[i + 1]);
        }

        long max = -1;
        long prefixMax = nums[0];
        for (int i = 1; i < n - 1; i++) {
            long value = (prefixMax - nums[i]) * suffixMaxes[i + 1];
            max = Math.max(value, max);
            prefixMax = Math.max(nums[i], prefixMax);
        }
        return max < 0 ? 0 : max;
    }
}
