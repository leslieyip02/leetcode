class Solution {
    public int maxSubArray(int[] nums) {
        int maximum = nums[0];
        int current = 0;
        for (int num : nums) {
            current += num;
            if (current > maximum) {
                maximum = current;
            }
            if (current < 0) {
                current = 0;
            }
        }
        return maximum;
    }
}
