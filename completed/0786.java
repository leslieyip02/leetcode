import java.util.*;

class Solution {
    private class Fraction implements Comparable<Fraction> {
        int numerator;
        int denominator;
        double value;

        public Fraction(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            this.value = (double) numerator / denominator;
        }

        public int compareTo(Fraction other) {
            return (int) Math.signum(this.value - other.value);
        }
    }

    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                pq.add(new Fraction(arr[i], arr[j]));
            }
        }

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        Fraction target = pq.poll();
        return new int[]{ target.numerator, target.denominator };
    }
}
