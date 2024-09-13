class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > furthest) {
                return false;
            }
            furthest = Math.max(i + nums[i], furthest);
        }
        return true;
    }
}
