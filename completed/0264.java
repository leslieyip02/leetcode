import java.util.*;

class Solution {
    private static final int[] FACTORS = new int[]{ 2, 3, 5 };

    public int nthUglyNumber(int n) {
        TreeSet<Long> tree = new TreeSet<>();
        tree.add(1L);
        for (int i = 1; i < n; i++) {
            long current = tree.pollFirst();
            for (int factor : FACTORS) {
                tree.add(current * factor);
            }
        }
        return tree.pollFirst().intValue();
    }
}
