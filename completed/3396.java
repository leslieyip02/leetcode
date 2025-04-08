class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int i = nums.length / 3; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                int k = i * 3 + j;
                if (k >= nums.length) {
                    break;
                }
                if (seen.contains(nums[k])) {
                    return i + 1;
                }
                seen.add(nums[k]);
            }
        }
        return 0;
    }
}
