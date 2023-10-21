import java.util.*;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int maximumSum = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Deque<Integer> previous = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (!previous.isEmpty()) {
                dp[i] += dp[previous.peekFirst()];
            }
            maximumSum = Math.max(dp[i], maximumSum);

            while (!previous.isEmpty()) { 
                if (i - previous.peekFirst() >= k) {
                    previous.removeFirst();
                } else if (dp[i] >= dp[previous.peekLast()]) {
                    previous.removeLast();
                } else {
                    break;
                }
            }

            if (dp[i] > 0) {
                previous.addLast(i);
            }
        }

        return maximumSum;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 2, -10, 5, 20 };
        int k = 2;
        // int[] nums = { -1, -2, -3 };
        // int k = 1;
        // int[] nums = { 10, -2, -10, -5, 20 };
        // int k = 2;

        Solution solution = new Solution();
        System.out.println(solution.constrainedSubsetSum(nums, k));
    }
}
