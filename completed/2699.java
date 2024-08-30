import java.util.*;

class Solution {
    private static final int INFINITY = (int) 1e9;

    private class Node implements Comparable<Node> {
        public int index;
        public int distance;
        public Map<Integer, Integer> adjacents;

        public Node(int index) {
            this.index = index;
            this.distance = INFINITY;
            this.adjacents = new HashMap<>();
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null || !(other instanceof Node)) {
                return false;
            }
            return this.index == ((Node) other).index;
        }
    }

    private int shortestDistance(int n, int[][] edges, int source, int destination) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int w = edge[2];
            if (w < 0) {
                continue;
            }
            nodes[a].adjacents.put(b, w);
            nodes[b].adjacents.put(a, w);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        nodes[source].distance = 0;
        pq.add(nodes[source]);
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            for (Map.Entry<Integer, Integer> adjacent : current.adjacents.entrySet()) {
                Node adjacentNode = nodes[adjacent.getKey()];
                int distance = current.distance + adjacent.getValue();
                if (distance < adjacentNode.distance) {
                    pq.remove(adjacentNode);
                    adjacentNode.distance = distance;
                    pq.add(adjacentNode);
                }
            }
        }
        return nodes[destination].distance;
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {        
        int distance = shortestDistance(n, edges, source, destination);
        if (distance < target) {
            return new int[0][0];
        }

        boolean ok = distance == target;
        for (int[] edge : edges) {
            if (edge[2] > 0) {
                continue;
            }

            // if the solution has been found,
            // the other edges don't matter
            edge[2] = ok ? INFINITY : 1;
            if (!ok) {
                int current = shortestDistance(n, edges, source, destination);
                if (current <= target) {
                    ok = true;
                    edge[2] += target - current;
                }
            }
        }
        return ok ? edges : new int[0][0];
    }
}
