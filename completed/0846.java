import java.util.*;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> f = new TreeMap<>();
        for (int card : hand) {
            f.put(card, f.getOrDefault(card, 0) + 1);
        }

        while (!f.isEmpty()) {
            int start = f.firstKey();
            for (int i = 0; i < groupSize; i++) {
                int card = start + i;
                if (!f.containsKey(card)) {
                    return false;
                }

                int current = f.get(card);
                if (current == 1) {
                    f.remove(card);
                } else {
                    f.put(card, current - 1);
                }
            }
        }
        return true;
    }
}
