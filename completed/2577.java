import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class Move implements Comparable<Move> {
        int i;
        int j;
        int t;

        public Move(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }

        @Override
        public int compareTo(Move other) {
            return t - other.t;
        }
    }

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // trapped in top left corner
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Move> moves = new PriorityQueue<>();
        moves.add(new Move(0, 0, 0));
        while (!moves.isEmpty()) {
            Move current = moves.poll();
            if (visited[current.i][current.j]) {
                continue;
            }
            visited[current.i][current.j] = true;

            for (int[] direction : DIRECTIONS) {
                int i = current.i + direction[0];
                int j = current.j + direction[1];
                if (i < 0 || i >= m || j < 0 || j >= n) {
                    continue;
                }

                int t = current.t + 1;
                if (t < grid[i][j]) {
                    t += Math.ceil((grid[i][j] - t) / 2.0) * 2;
                }
                if (i == m - 1 && j == n - 1) {
                    return t;
                }
                moves.add(new Move(i, j, t));
            }
        }
        return -1;
    }
}
