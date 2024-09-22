import java.util.*;

class Solution {
    private class Worker implements Comparable<Worker> {
        long time;
        long height;
        long total;

        public Worker(long time) {
            this.time = time;
            this.height = 1;
            this.total = time;
        }

        @Override
        public int compareTo(Worker other) {
            return Long.compare(this.total, other.total);
        }
    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        PriorityQueue<Worker> workers = new PriorityQueue<>();
        for (int time : workerTimes) {
            workers.add(new Worker((long) time));
        }

        long total = 0;
        while (mountainHeight > 0) {
            Worker current = workers.poll();
            mountainHeight--;
            total = Math.max(current.total, total);

            current.height++;
            current.total += current.time * current.height;
            workers.add(current);
        }
        return total;
    }
}
