class Solution {
    public int minSwaps(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }
        if (ones == 0 || ones == nums.length) {
            return 0;
        }

        int current = 0;
        for (int i = 0; i < ones; i++) {
            if (nums[i] == 1) {
                current++;
            }
        }
        int swaps = ones - current;
        for (int left = 0; left < nums.length; left++) {
            int right = (left + ones) % nums.length;
            current -= nums[left] == 1 ? 1 : 0;
            current += nums[right] == 1 ? 1 : 0;
            swaps = Math.min(ones - current, swaps);
        }
        return swaps;
    }
}
