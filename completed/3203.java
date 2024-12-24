import java.util.*;

class Solution {
    private int diameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }

        Map<Integer, List<Integer>> adjacents = new HashMap<>();
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacents.computeIfAbsent(a, _ -> new ArrayList<>()).add(b);
            adjacents.computeIfAbsent(b, _ -> new ArrayList<>()).add(a);
        }

        // BFS from arbitrary node to reach a leaf node
        Queue<Integer> nodes = new LinkedList<>();
        int current = 0;
        nodes.add(current);
        Set<Integer> visited = new HashSet<>();
        while (!nodes.isEmpty()) {
            current = nodes.poll();
            visited.add(current);
            for (int adjacent : adjacents.get(current)) {
                if (visited.contains(adjacent)) {
                    continue;
                }
                nodes.add(adjacent);
            }
        }

        // BFS from leaf node to find diameter
        nodes.add(current);
        visited.clear();
        int level = 0;
        while (!nodes.isEmpty()) {
            Queue<Integer> buffer = new LinkedList<>();
            while (!nodes.isEmpty()) {
                current = nodes.poll();
                visited.add(current);
                for (int adjacent : adjacents.get(current)) {
                    if (visited.contains(adjacent)) {
                        continue;
                    }
                    buffer.add(adjacent);
                }
            }
            level++;
            nodes = buffer;
        }
        return level - 1;
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = diameter(edges1);
        int d2 = diameter(edges2);
        int d3 = (int) (Math.ceil(d1 / 2.0) + Math.ceil(d2 / 2.0) + 1);
        return Math.max(d1, Math.max(d2, d3));
    }
}
