import java.util.*;

class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        boolean[][] g = new boolean[n][n];
        int[] indegrees = new int[n];
        for (int i = 0; i < richer.length; i++) {
            int a = richer[i][0];
            int b = richer[i][1];
            g[a][b] = true;
            indegrees[b]++;
        }

        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                nodes.add(i);
            }
        }

        int[] results = new int[n];
        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            results[current] = current;

            for (int i = 0; i < n; i++) {
                if (g[i][current] && quiet[results[i]] < quiet[results[current]]) {
                    results[current] = results[i];
                }
            }

            for (int i = 0; i < n; i++) {
                if (g[current][i]) {
                    indegrees[i]--;
                    if (indegrees[i] == 0) {
                        nodes.add(i);
                    }
                }
            }
        }
        return results;
    }
}
