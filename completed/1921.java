import java.util.*;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] times = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            times[i] = (double) dist[i] / speed[i];
        }
        Arrays.sort(times);
        int t = 0;
        while (t < dist.length && times[t] > t) {
            t++;
        }
        return t; 
    }

    public static void main(String[] args) {
        // int[] dist = { 1, 1, 3, 2 };
        // int[] speed = { 1, 1, 1, 1 };
        // int[] dist = { 3, 5, 7, 4, 5 };
        // int[] speed = { 2, 3, 6, 3, 2 };
        int[] dist = { 4, 3, 3 };
        int[] speed = { 1, 1, 2 };

        Solution solution = new Solution();
        System.out.println(solution.eliminateMaximum(dist, speed));
    }
}
