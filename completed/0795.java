class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0;
        int leftIndex = -1;
        int rightIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                leftIndex = i;
            }
            if (nums[i] >= left) {
                rightIndex = i;
            }
            count += rightIndex - leftIndex;
        }
        return count;
    }
}
