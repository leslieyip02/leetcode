import java.util.*;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int i : arr) {
            counts.put(i, counts.getOrDefault(i, 0) + 1);
        }
        Set<Integer> unique = new HashSet<>();
        for (int i : counts.values()) {
            if (unique.contains(i)) {
                return false;
            }
            unique.add(i);
        }
        return true;
    }
}
