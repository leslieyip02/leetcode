import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int num1;
        int num2;
        int sum;

        public Pair(int num1, int num2) {
            this.num1 = num1;
            this.num2 = num2;
            this.sum = num1 + num2;
        }

        @Override
        public int compareTo(Pair other) {
            return other.sum - this.sum;
        }

        public List<Integer> toList() {
            List<Integer> list = new ArrayList<>();
            list.add(this.num1);
            list.add(this.num2);
            return list;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // sort ascending
        PriorityQueue<Pair> pairs = new PriorityQueue<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Pair pair = new Pair(nums1[i], nums2[j]);
                if (pairs.size() < k) {
                    pairs.add(pair);
                } else if (pairs.peek().compareTo(pair) < 0) {
                    pairs.poll();
                    pairs.add(pair);
                } else {
                    break;
                }
            }
        }

        List<List<Integer>> smallest = new ArrayList<>();
        while (!pairs.isEmpty()) {
            smallest.add(pairs.poll().toList());
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        // int[] nums1 = { 1, 1, 2 };
        // int[] nums2 = { 1, 2, 3 };
        // int k = 2;
        // int[] nums1 = { 1, 2 };
        // int[] nums2 = { 3 };
        // int k = 3;

        Solution solution = new Solution();
        var results = solution.kSmallestPairs(nums1, nums2, k);
        for (var result : results) {
            System.out.println(String.format("%d %d", result.get(0), result.get(1)));
        }
    }
}
