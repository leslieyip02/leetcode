import java.util.*;

class Solution {
    private long[][] memo;

    private long find(int index, int even, int[] nums, int k) {
        if (index == nums.length) {
            return even == 1 ? 0 : Long.MIN_VALUE;
        }

        if (memo[index][even] == -1) {
            // xor
            long x = (nums[index] ^ k) + find(index + 1, even ^ 1, nums, k);
            // don't xor
            long y = nums[index] + find(index + 1, even, nums, k);

            memo[index][even] = Math.max(x, y);
        }

        return memo[index][even];
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        memo = new long[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return find(0, 1, nums, k);
    }
}
