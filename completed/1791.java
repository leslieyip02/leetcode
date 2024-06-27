import java.util.*;

class Solution {
    public int findCenter(int[][] edges) {
        Set<Integer> seen = new HashSet<>();
        for (int[] edge : edges) {
            for (int node : edge) {
                if (seen.contains(node)) {
                    return node;
                } else {
                    seen.add(node);
                }
            }
        }
        return -1;
    }
}
