import java.util.*;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> piles = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            piles.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int current = piles.poll();
            piles.add((int) Math.floor(Math.sqrt(current)));
        }

        long remaining = 0;
        while (!piles.isEmpty()) {
            remaining += piles.poll();
        }
        return remaining;
    }
}
