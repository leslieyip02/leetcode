import java.util.*;

class Solution {
    private List<Integer> helper(int current, int max) {
        List<Integer> results = new ArrayList<>();
        if (current > max) {
            return results;
        }

        results.add(current);
        results.addAll(helper(current * 10, max));
        for (int i = 1; i <= 9; i++) {
            if (current + i > max) {
                break;
            }
            results.add(current + i);
            results.addAll(helper((current + i) * 10, max));
        }
        return results;
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (i > n) {
                break;
            }
            results.add(i);
            results.addAll(helper(i * 10, n));
        }
        return results;
    }
}
