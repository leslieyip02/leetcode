import java.util.*;

class Solution {
    private static final int INF = (int) 1e6;

    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Move implements Comparable<Move> {
        int i;
        int j;
        int cost;

        public Move(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }

        @Override
        public int compareTo(Move other) {
            return cost - other.cost;
        }
    }

    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] removed = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(removed[i], INF);
        }

        PriorityQueue<Move> moves = new PriorityQueue<>();
        moves.add(new Move(0, 0, 0));
        while (removed[m - 1][n - 1] == INF) {
            Move current = moves.poll();
            if (current.cost < removed[current.i][current.j]) {
                removed[current.i][current.j] = current.cost;

                for (int[] direction : DIRECTIONS) {
                    int i = current.i + direction[0];
                    int j = current.j + direction[1];
                    if (i < 0 || i >= m || j < 0 || j >= n) {
                        continue;
                    }
                    int cost = current.cost + (grid[i][j] == 1 ? 1 : 0);
                    moves.add(new Move(i, j, cost));
                }
            }
        }
        return removed[m - 1][n - 1];
    }
}
