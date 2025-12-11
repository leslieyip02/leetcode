class Solution {

    private static final int[][] directions = new int[][]{
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 }
    };

    private boolean canReachHelper(int i0, int j0, int[][] grid, int t, boolean[][] visited) {
        int n = grid.length;
        if (i0 == n - 1 && j0 == n - 1) {
            return true;
        }

        visited[i0][j0] = true;
        for (int[] direction : directions) {
            int i1 = i0 + direction[0];
            int j1 = j0 + direction[1];
            if (i1 < 0 || i1 >= n || j1 < 0 || j1 >= n) {
                continue;
            }

            if (visited[i1][j1] || grid[i1][j1] > t) {
                continue;
            }

            if (canReachHelper(i1, j1, grid, t, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean canReach(int[][] grid, int t) {
        if (grid[0][0] > t) {
            return false;
        }

        int n = grid.length;
        return canReachHelper(0, 0, grid, t, new boolean[n][n]);
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = 0;
        int high = n * n + 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (canReach(grid, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
