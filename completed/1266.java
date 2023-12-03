import java.util.*;

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] current = points[0];
        int time = 0;
        for (int i = 1; i < points.length; i++) {
            int dx = Math.abs(points[i][0] - current[0]);
            int dy = Math.abs(points[i][1] - current[1]);
            time += Math.max(dx, dy);
            current = points[i];
        }
        return time;
    }

    public static void main(String[] args) {
        int[][] points = { { 1, 1 }, { 3, 4 }, { -1, 0 } };

        Solution solution = new Solution();
        System.out.println(solution.minTimeToVisitAllPoints(points));
    }
}
