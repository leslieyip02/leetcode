import java.util.*;

class Solution {
    private class Entry implements Comparable<Entry> {
        int i;
        int j;
        int value;

        public Entry(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Entry other) {
            return value - other.value;
        }
    }

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        PriorityQueue<Entry> entries = new PriorityQueue<>();
        int max = (int) -1e6;
        for (int i = 0; i < k; i++) {
            entries.add(new Entry(i, 0, nums.get(i).get(0)));
            max = Math.max(nums.get(i).get(0), max);
        }

        int start = entries.peek().value;
        int end = max;
        while (true) {
            Entry smallest = entries.poll();
            if (max - smallest.value < end - start) {
                start = smallest.value;
                end = max;
                end = max;
            }

            int i = smallest.i;
            int j = smallest.j;
            if (j + 1 >= nums.get(i).size()) {
                break;
            }
            entries.add(new Entry(i, j + 1, nums.get(i).get(j + 1)));
            max = Math.max(nums.get(i).get(j + 1), max);
        }
        return new int[]{ start, end };
    }
}
