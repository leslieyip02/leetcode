class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int num : nums) {
            ops += (num % 3 == 0) ? 0 : 1;
        }
        return ops;
    }
}
