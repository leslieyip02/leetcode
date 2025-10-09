class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int previous = (int) -5e4 - 1;
        for (int[] interval : intervals) {
            if (interval[0] < previous) {
                count++;
            } else {
                previous = interval[1];
            }
        }
        return count;
    }
}
