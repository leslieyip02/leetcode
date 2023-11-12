import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        int maxIndex = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxIndex = Math.max(stop, maxIndex);
            }
        }
        if (maxIndex < target) {
            return -1;
        }

        int[] buses = new int[maxIndex + 1];
        Arrays.fill(buses, Integer.MAX_VALUE);
        buses[source] = 0;

        boolean done = false;
        while (!done) {
            done = true;
            for (int[] route : routes) {
                int minBuses = Integer.MAX_VALUE;
                for (int stop : route) {
                    minBuses = Math.min(buses[stop], minBuses);
                }
                if (minBuses == Integer.MAX_VALUE) {
                    continue;
                }
                minBuses++;

                for (int stop : route) {
                    if (minBuses < buses[stop]) {
                        buses[stop] = minBuses;
                        done = false;
                    }
                }
            }
        }

        return buses[target] == Integer.MAX_VALUE
            ? -1 : buses[target];
    }

    public static void main(String[] args) {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1;
        int target = 6;
        // int[][] routes = { { 7, 12 }, { 4, 5, 15 }, { 6 }, { 15, 19 }, { 9, 12, 13 } };
        // int source = 15;
        // int target = 12;

        Solution solution = new Solution();
        System.out.println(solution.numBusesToDestination(routes, source, target));
    }
}
