class Solution {

    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    private int helper(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }

        int ones = 0;
        int[] gcds = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            gcds[i] = gcd(nums[i], nums[i + 1]);
            if (gcds[i] == 1) {
                ones++;
            }
        }

        if (ones > 0) {
            return 0;
        }

        int next = helper(gcds);
        return next == -1 ? -1 : next + 1;
    }

    public int minOperations(int[] nums) {
        int ones = 0;
        for (int num : nums) {
            if (num == 1) {
                ones++;
            }
        }

        int depth = helper(nums);
        if (depth == -1) {
            return -1;
        }
        return nums.length + depth - ones;
    }
}
