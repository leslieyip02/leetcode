import java.util.*;

class Solution {
    private static final int TYPE_1 = 0;
    private static final int TYPE_2 = 1;
    private static final int TYPE_3 = 2;

    private int find(int i, int[] parents) {
        if (i != parents[i]) {
            parents[i] = find(parents[i], parents);
        }
        return parents[i];
    }

    private boolean union(int i, int j, int[] parents) {
        i = find(i, parents);
        j = find(j, parents);
        if (i == j) {
            return false;
        } 

        parents[i] = j;
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
        int count = 0;
        int[][] parents = new int[3][n];
        for (int i = 0; i < n; i++) {
            parents[TYPE_3][i] = i;
        }
        for (int[] edge : edges) {
            int type = edge[0] - 1;
            if (type != TYPE_3) {
                continue;
            }

            int u = edge[1] - 1;
            int v = edge[2] - 1;
            if (union(u, v, parents[TYPE_3])) {
                count++;
            }
        }

        for (int i = TYPE_1; i <= TYPE_2; i++) {
            System.arraycopy(parents[TYPE_3], 0, parents[i], 0, n);
            for (int[] edge : edges) {
                int type = edge[0] - 1;
                if (type != i) {
                    continue;
                }

                int u = edge[1] - 1;
                int v = edge[2] - 1;
                if (union(u, v, parents[i])) {
                    count++;
                }
            }

            int parent = find(0, parents[i]);
            for (int j = 1; j < n; j++) {
                if (find(j, parents[i]) != parent) {
                    return -1;
                }
            }
        }
        return edges.length - count;
    }
}
