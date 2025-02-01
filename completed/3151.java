class Solution {
    public boolean isArraySpecial(int[] nums) {
        boolean isEven = nums[0] % 2 == 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] % 2 == 0) == isEven) {
                return false;
            }
            isEven = !isEven;
        }
        return true;
    }
}
