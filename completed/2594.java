class Solution {
    private class Repair implements Comparable<Repair> {
        private int r;
        private int n;
        public long cost;

        public Repair(int r) {
            this.r = r;
            this.n = 1;
            this.cost = r;
        }

        private Repair addRepair() {
            Repair next = new Repair(r);
            next.n = n + 1;
            next.cost = (long) r * next.n * next.n;
            return next;
        }

        @Override
        public int compareTo(Repair other) {
            return Long.compare(cost, other.cost);
        }
    }

    public long repairCars(int[] ranks, int cars) {
        PriorityQueue<Repair> repairs = new PriorityQueue<>();
        for (int rank : ranks) {
            repairs.add(new Repair(rank));
        }

        long time = 0;
        while (cars > 0) {
            Repair current = repairs.poll();
            time = current.cost;
            cars--;
            repairs.add(current.addRepair());
        }
        return time;
    }
}
