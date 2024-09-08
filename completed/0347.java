import java.util.*;

class Solution {
    class Entry implements Comparable<Entry> {
        int num;
        int frequency;

        Entry(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Entry other) {
            return this.frequency - other.frequency;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            pq.add(new Entry(entry.getKey(), entry.getValue()));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] mostFrequent = new int[k];
        for (int i = 0; i < k; i++) {
            mostFrequent[i] = pq.poll().num;
        }
        return mostFrequent;
    }
}
