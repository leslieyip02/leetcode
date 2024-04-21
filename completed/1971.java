import java.util.*;

class Solution {
    private int find(int[] parents, int i) {
        if (parents[i] == i) {
            return i;
        } else {
            int parent = find(parents, parents[i]);
            parents[i] = parent;
            return parent;
        }
    }

    private void union(int[] parents, int i, int j) {
        int p = find(parents, i);
        int q = find(parents, j);
        parents[p] = q;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (var edge : edges) {
            int i = edge[0];
            int j = edge[1];
            union(parents, i, j);
        }

        return find(parents, source) == find(parents, destination);
    }
}
