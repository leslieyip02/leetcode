import java.util.*;

class Solution {
    class Time implements Comparable<Time> {
        int value;
        int score;
        boolean isStart;

        public Time(int value, int score, boolean isStart) {
            this.value = value;
            this.score = score;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Time other) {
            return value == other.value
                ? (isStart ? (other.isStart ? 0 : -1) : 1)
                : value - other.value;
        }
    }

    public int maxTwoEvents(int[][] events) {
        List<Time> times = new ArrayList<>();
        for (int[] event : events) {
            times.add(new Time(event[0], event[2], true));
            times.add(new Time(event[1], event[2], false));
        }
        Collections.sort(times);

        Time maxPreviousTime = new Time(0, 0, true);
        int maxTotalScore = 0;
        for (Time time : times) {
            if (time.isStart) {
                if (time.value <= maxPreviousTime.value) {
                    continue;
                }
                maxTotalScore = Math.max(maxPreviousTime.score + time.score, maxTotalScore);
            } else {
                if (time.score > maxPreviousTime.score) {
                    maxTotalScore = Math.max(time.score, maxTotalScore);
                    maxPreviousTime = time;
                }
            }
        }
        return maxTotalScore;
    }
}
