import java.util.*;

class Solution {
    private static final int INFINITY = (int) 5e8 + 1;

    private ArrayList<HashMap<Integer, Integer>> memo;

    private int paint(int wall, int extra, int[] cost, int[] time) {
        if (wall == cost.length) {
            return extra < 0 ? Solution.INFINITY :  0;
        }
        if (memo.get(wall).get(extra) != null) {
            return memo.get(wall).get(extra);
        }
        if (wall + extra >= cost.length) {
            return 0;
        }

        // pick this wall
        int minCost = cost[wall] + paint(wall + 1, extra + time[wall], cost, time);
        // use a free painter
        minCost = Math.min(paint(wall + 1, extra - 1, cost, time), minCost);
        this.memo.get(wall).put(extra, minCost);
        return minCost;
    }

    public int paintWalls(int[] cost, int[] time) {
        this.memo = new ArrayList<>();
        for (int i = 0; i < cost.length; i++) {
            this.memo.add(new HashMap<>());
        }
        return this.paint(0, 0, cost, time);
    }

    public static void main(String[] args) {
        int[] cost = { 2, 3, 4, 2 };
        int[] time = { 1, 1, 1, 1 };

        Solution solution = new Solution();
        System.out.println(solution.paintWalls(cost, time));
    }
}
