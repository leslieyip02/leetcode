import java.util.Arrays;

class Solution {
    private int[] memo;

    private int climb(int current, int[] cost) {
        if (current >= cost.length) {
            return 0;
        }

        if (memo[current] == -1) {
            memo[current] = cost[current] + Math.min(
                this.climb(current + 1, cost),
                this.climb(current + 2, cost)
            );
        }
        return memo[current];
    }

    public int minCostClimbingStairs(int[] cost) {
        this.memo = new int[cost.length];
        Arrays.fill(memo, -1);
        return Math.min(this.climb(0, cost),
                        this.climb(1, cost));
    }

    public static void main(String[] args) {
        // int[] cost = { 10, 15, 20 };
        int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

        Solution solution = new Solution();
        System.out.println(solution.minCostClimbingStairs(cost));
    }
}
