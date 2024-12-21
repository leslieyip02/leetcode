import java.util.*;

class Solution {
    private static int count;

    private long merge(int root, Map<Integer, Set<Integer>> adjacents, int[] values, int k) {
        long sum = values[root];
        for (int adjacent : adjacents.get(root)) {
            adjacents.get(adjacent).remove(root);
            sum += merge(adjacent, adjacents, values, k);
        }

        if (sum % k == 0) {
            sum = 0;
            count++;
        }

        return sum;
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        if (n == 1) {
            return 1;
        }

        count = 0;
        HashMap<Integer, Set<Integer>> adjacents = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacents.computeIfAbsent(a, _ -> new HashSet<>()).add(b);
            adjacents.computeIfAbsent(b, _ -> new HashSet<>()).add(a);
        }
        merge(0, adjacents, values, k);
        return count;
    }
}
