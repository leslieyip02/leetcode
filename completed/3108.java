class Solution {
    private int find(int a, int[] parents) {
        if (parents[a] == a) {
            return a;
        }
        parents[a] = find(parents[a], parents);
        return parents[a];
    }

    private int merge(int a, int b, int[] parents) {
        parents[find(b, parents)] = find(a, parents);
        return parents[a];
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int[] parents = new int[n];
        int[] depths = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int[] edge : edges) {
            merge(edge[0], edge[1], parents);
        }

        int[] weights = new int[n];
        Arrays.fill(weights, Integer.MAX_VALUE);
        for (int[] edge : edges) {
            weights[find(edge[0], parents)] &= edge[2];
        }

        int[] answer = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int a = find(query[i][0], parents);
            int b = find(query[i][1], parents);
            answer[i] = a == b ? weights[a] : -1;
        }
        return answer;
    }
}
