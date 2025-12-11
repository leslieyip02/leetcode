class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        int right = nums.length - 1;
        boolean found = false;
        while (left >= 0) {
            right = nums.length - 1;
            while (right > left) {
                if (nums[right] > nums[left]) {
                    found = true;
                    break;
                }
                right--;
            }

            if (found) {
                break;
            }
            left--;
        }   

        if (!found) {
            Arrays.sort(nums);
            return;
        }

        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;

        Arrays.sort(nums, left + 1, nums.length);
    }
}
