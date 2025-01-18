import java.util.*;

class Solution {
    class Node implements Comparable<Node> {
        int sign;
        int cost;
        boolean isVisited;
        boolean isGoal;
        Node[] adjacents;

        public Node(int sign) {
            this.sign = sign - 1;
            this.cost = (int) 1e9;
            this.isVisited = false;
            this.isGoal = false;
            this.adjacents = new Node[4];
        }

        @Override
        public int compareTo(Node other) {
            return cost - other.cost;
        }
    }

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Node[][] nodes = new Node[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j] = new Node(grid[i][j]);
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                nodes[i][j].adjacents[0] = j + 1 < n ? nodes[i][j + 1] : null;
                nodes[i][j].adjacents[1] = j - 1 >= 0 ? nodes[i][j - 1] : null;
                nodes[i][j].adjacents[2] = i + 1 < m ? nodes[i + 1][j] : null;
                nodes[i][j].adjacents[3] = i - 1 >= 0 ? nodes[i - 1][j] : null;
            }
        }

        PriorityQueue<Node> frontier = new PriorityQueue<>();
        nodes[0][0].cost = 0;
        nodes[m - 1][n - 1].isGoal = true;
        frontier.add(nodes[0][0]);
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();
            if (current.isGoal) {
                return current.cost;
            }

            current.isVisited = true;
            for (int i = 0; i < 4; i++) {
                Node next = current.adjacents[i];
                if (next == null || next.isVisited) {
                    continue;
                }

                int cost = current.cost + (i == current.sign ? 0 : 1);
                if (cost < next.cost) {
                    frontier.remove(next);
                    next.cost = cost;
                    frontier.add(next);
                }
            }
        }
        return -1;
    }
}
