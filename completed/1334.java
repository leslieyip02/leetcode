import java.util.*;

class Solution {
    private static final int INF = (int) 1e4 + 1;
    private static final int UNVISITED = -1;

    private int dfs(int current, int threshold, int[][] graph, int[] visited) {
        int reachable = 0;
        if (visited[current] == UNVISITED) {
            reachable++;
        }
        visited[current] = Math.max(threshold, visited[current]);

        for (int i = 0; i < graph.length; i++) {
            int newThreshold = threshold - graph[current][i];
            if (newThreshold >= 0 && newThreshold > visited[i]) {
                reachable += dfs(i, newThreshold, graph, visited);
            }
        }
        return reachable;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        int[] reachables = new int[n];
        for (int i = 0; i < n; i++) {
            int[] visited = new int[n];
            Arrays.fill(visited, UNVISITED);
            reachables[i] = dfs(i, distanceThreshold, graph, visited);
        }

        int result = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (reachables[i] < reachables[result]) {
                result = i;
            }
        }
        return result;
    }
}
