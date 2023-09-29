class Solution {
    public boolean isMonotonic(int[] nums) {
        int ascending = 0;
        int descending = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                if (descending > 0) {
                    return false;
                }
                ascending++;
            } else if (nums[i] < nums[i - 1]) {
                if (ascending > 0) {
                    return false;
                }
                descending++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 1 };

        Solution solution = new Solution();
        System.out.println(solution.isMonotonic(nums));
    }
}
