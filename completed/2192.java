import java.util.*;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<SortedSet<Integer>> ancestors = new ArrayList<>();
        List<List<Integer>> children = new ArrayList<>();
        int[] indegrees = new int[n];

        for (int i = 0; i < n; i++) {
            ancestors.add(new TreeSet<>());
            children.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];

            children.get(from).add(to);
            indegrees[to]++;
        }

        // topological sort
        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                nodes.add(i);
            }
        }

        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            for (int child : children.get(current)) {
                ancestors.get(child).add(current);
                ancestors.get(child).addAll(ancestors.get(current));

                indegrees[child]--;
                if (indegrees[child] == 0) {
                    nodes.add(child);
                }
            }
        }

        List<List<Integer>> results = new ArrayList<>();
        for (SortedSet<Integer> set : ancestors) {
            results.add(new ArrayList<>(set));
        }
        return results;
    }
}
