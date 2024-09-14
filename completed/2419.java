class Solution {
    public int longestSubarray(int[] nums) {
        int maximum = 0;
        for (int num : nums) {
            maximum = Math.max(num, maximum);
        }

        int longest = 1;
        int left = 0;
        int right = 0;
        while (left < nums.length) {
            if (nums[left] == maximum) {
                right = left + 1;
                while (right < nums.length && nums[right] == maximum) {
                    right++;
                }
                longest = Math.max(right - left, longest);
                left = right;
            } else {
                left++;
            }
        }
        return longest;
    }
}
