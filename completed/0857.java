import java.util.*;

class Solution {
    private class Worker implements Comparable<Worker> {
        public int quality;
        public double rate;

        public Worker(int quality, int wage) {
            this.quality = quality;
            this.rate = (double) wage / quality;
        }

        public int compareTo(Worker other) {
            return (int) Math.signum(this.rate - other.rate);
        }
    }

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int totalQuality = 0;
        Worker[] workers = new Worker[quality.length];
        for (int i = 0; i < quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers);

        // maintain a max heap of workers based on quality
        PriorityQueue<Integer> selected = new PriorityQueue<>((a, b) -> b - a);
        double totalCost = Double.MAX_VALUE;
        for (int i = 0; i < workers.length; i++) {
            totalQuality += workers[i].quality;
            selected.add(workers[i].quality);
            // get rid of highest quality worker
            if (selected.size() > k) {
                totalQuality -= selected.poll();
            }
            if (selected.size() == k) {
                totalCost = Math.min(totalQuality * workers[i].rate, totalCost);
            }
        }
        return totalCost;
    }
}
