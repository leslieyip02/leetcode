import java.util.*;

class Solution {
    public int minimumPushes(String word) {
        int[] f = new int[26];
        for (int i = 0; i < word.length(); i++) {
            f[(int) word.charAt(i) - 97]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int v : f) {
            if (v == 0) {
                continue;
            }
            pq.add(v);
        }

        int presses = 1;
        int total = 0;
        while (!pq.isEmpty()) {
            for (int i = 0; i < 8 && !pq.isEmpty(); i++) {
                int v = pq.poll();
                total += v * presses;
            }
            presses++;
        }
        return total;
    }
}
