import java.util.*;

class Solution {
    private int split(String s, int index, int current, Set<String> seen) {
        int max = current;
        for (int i = index; i < s.length(); i++) {
            String ss = s.substring(index, i + 1);
            if (!seen.contains(ss)) {
                seen.add(ss);
                max = Math.max(split(s, i + 1, current + 1, seen), max);
                seen.remove(ss);
            }
        }
        return max;
    }

    public int maxUniqueSplit(String s) {
        return split(s, 0, 0, new HashSet<>());
    }
}
