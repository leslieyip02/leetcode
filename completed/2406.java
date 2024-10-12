import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();

        int result = 0;
        for (int[] interval : intervals) {
            while (!endTimes.isEmpty() && interval[0] > endTimes.peek()) {
                endTimes.poll();
            }
            endTimes.add(interval[1]);
            result = Math.max(endTimes.size(), result);
        }
        return result;
    }
}
