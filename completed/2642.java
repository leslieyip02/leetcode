import java.util.*;

class Graph {
    private static final int INF = -1;
    private int[][] edges;

    public Graph(int n, int[][] edges) {
        this.edges = new int[n][n];
        for (int[] row : this.edges) {
            Arrays.fill(row, Graph.INF);
        }
        for (int[] edge : edges) {
            this.addEdge(edge);
        }
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int edgeCost = edge[2];
        this.edges[from][to] = edgeCost;
    }
    
    public int shortestPath(int node1, int node2) {
        int[] distances = new int[edges.length];
        boolean[] visited = new boolean[edges.length];
        Arrays.fill(distances, Graph.INF);
        distances[node1] = 0;

        for (int i = 0; i < edges.length; i++) {
            int from = Graph.INF;
            for (int j = 0; j < edges.length; j++) {
                if (!visited[j] && distances[j] != Graph.INF &&
                    (from == Graph.INF || distances[j] < distances[from])) {
                    from = j;
                }
            }
            if (from == Graph.INF) {
                break;
            }
            visited[from] = true;

            for (int to = 0; to < edges.length; to++) {
                if (!visited[to] && this.edges[from][to] != Graph.INF) {
                    if (distances[to] == Graph.INF || distances[from] + this.edges[from][to] < distances[to]) {
                        distances[to] = distances[from] + this.edges[from][to];
                    }
                }
            }
        }
        return distances[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
