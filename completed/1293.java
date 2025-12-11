class Solution {

    private static final int[][] directions = new int[][]{
        { 1, 0 },
        { 0, 1 },
        { -1, 0 },
        { 0, -1 }
    };

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][][] visited = new boolean[m][n][k + 1];

        Queue<Integer[]> toBeVisited = new ArrayDeque<>();
        toBeVisited.add(new Integer[]{ 0, 0, 0, 0 });
        while (!toBeVisited.isEmpty()) {
            Integer[] next = toBeVisited.poll();
            int i0 = next[0];
            int j0 = next[1];
            int used = next[2];
            if (visited[i0][j0][used]) {
                continue;
            }
            visited[i0][j0][used] = true;

            int cost = next[3];
            if (i0 == m - 1 && j0 == n - 1) {
                return cost;
            }

            for (int[] direction : directions) {
                int i1 = i0 + direction[0];
                int j1 = j0 + direction[1];
                if (i1 < 0 || i1 >= m || j1 < 0 || j1 >= n) {
                    continue;
                }

                if (grid[i1][j1] == 0) {
                    toBeVisited.add(new Integer[]{ i1, j1, used, cost + 1 });
                } else if (used + 1 <= k) {
                    toBeVisited.add(new Integer[]{ i1, j1, used + 1, cost + 1 });
                }
            }
        }
        return -1;
    }
}
