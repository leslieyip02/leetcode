import java.util.*;

class Solution {
    private class Time implements Comparable<Time> {
        private int h;
        private int m;

        public Time(String timePoint) {
            String[] tokens = timePoint.split(":");
            this.h = Integer.parseInt(tokens[0]);
            this.m = Integer.parseInt(tokens[1]);
        }

        @Override
        public int compareTo(Time other) {
            return this.h == other.h
                ? this.m - other.m
                : this.h - other.h;
        }

        public int difference(Time other) {
            return this.h == other.h
                ? (int) Math.abs(this.m - other.m)
                : Math.min(
                    ((this.h + 24 - other.h) % 24) * 60 + (this.m - other.m),
                    ((other.h + 24 - this.h) % 24) * 60 + (other.m - this.m)
                );
        }
    }

    public int findMinDifference(List<String> timePoints) {
        Time[] times = new Time[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            times[i] = new Time(timePoints.get(i));
        }
        Arrays.sort(times);

        int difference = times[0].difference(times[times.length - 1]);
        for (int i = 1; i < times.length; i++) {
            difference = Math.min(times[i].difference(times[i - 1]), difference);
        }
        return difference;
    }
}
