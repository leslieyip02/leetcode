import java.util.*;

class Solution {
    class Class implements Comparable<Class> {
        int pass;
        int total;

        public Class(int pass, int total) {
            this.pass = pass;
            this.total = total;
        }

        private double percentageChange() {
            double current = (double) pass / total;
            double next = Math.min((double) (pass + 1) / (total + 1), 1.0);
            return next - current;
        }

        @Override
        public int compareTo(Class other) {
            return (int) Math.signum(other.percentageChange() - this.percentageChange());
        }
    }

    public double maxAverageRatio(int[][] entries, int extraStudents) {
        PriorityQueue<Class> classes = new PriorityQueue<>();
        for (int[] entry : entries) {
            classes.add(new Class(entry[0], entry[1]));
        }

        for (int i = 0; i < extraStudents; i++) {
            Class current = classes.poll();
            classes.add(new Class(current.pass + 1, current.total + 1));
        }

        double total = 0;
        while (!classes.isEmpty()) {
            Class current = classes.poll();
            total += (double) current.pass / current.total;
        }
        return total / entries.length;
    }
}
