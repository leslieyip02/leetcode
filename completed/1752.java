class Solution {
    public boolean check(int[] nums) {
        boolean hasDescended = false;
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i % nums.length] < nums[i - 1]) {
                if (hasDescended) {
                    return false;
                }
                hasDescended = true;
            }
        }
        return true;
    }
}
