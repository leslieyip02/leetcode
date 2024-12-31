import java.util.*;

class Solution {
    int[][] memo;

    private int search(int[] days, int[] costs, int index, int covered) {
        if (index == days.length) {
            return 0;
        }

        if (memo[index][covered] != 0) {
            return memo[index][covered];
        }

        if (days[index] > covered) {
            int cost = costs[0] + search(days, costs, index + 1, days[index]);
            cost = Math.min(costs[1] + search(days, costs, index + 1, days[index] + 7 - 1), cost);
            cost = Math.min(costs[2] + search(days, costs, index + 1, days[index] + 30 - 1), cost);
            memo[index][covered] = cost;
            return cost;
        }

        int cost = search(days, costs, index + 1, covered);
        memo[index][covered] = cost;
        return cost;
    }

    public int mincostTickets(int[] days, int[] costs) {
        memo = new int[days.length][365 + 30];
        return search(days, costs, 0, 0);
    }
}
