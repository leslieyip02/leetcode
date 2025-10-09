class Solution {

    int find(int i, int[] parents) {
        if (parents[i] == i) {
            return i;
        }

        int parent = find(parents[i], parents);
        parents[i] = parent;
        return parent;
    }

    void union(int i, int j, int[] parents) {
        parents[find(i, parents)] = find(j, parents);
    }

    public int minCostConnectPoints(int[][] points) {
        List<Integer[]> edges = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int w = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new Integer[]{ i, j, w });
            }
        }
        Collections.sort(edges, (a, b) -> a[2] - b[2]);

        int[] parents = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            parents[i] = i;
        }

        int cost = 0;
        for (Integer[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            if (find(i, parents) == find(j, parents)) {
                continue;
            }

            union(i, j, parents);
            cost += edge[2];
        }
        return cost;
    }
}
