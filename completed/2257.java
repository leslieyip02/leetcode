class Solution {
    private static final int UNGUARDED = 0;
    private static final int WALL = 1;
    private static final int GUARD = 2;
    private static final int GUARDED = 3;
    private static final int[][] DIRECTIONS = new int[][]{{ 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] g = new int[m][n];
        for (int[] wall : walls) {
            g[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            g[guard[0]][guard[1]] = GUARD;
        }

        for (int[] guard : guards) {
            for (int[] direction : DIRECTIONS) {
                int dx = direction[0];
                int dy = direction[1];
                int x = guard[1] + dx;
                int y = guard[0] + dy;
                while (0 <= x && x < n && 0 <= y && y < m) {
                    if (g[y][x] == WALL || g[y][x] == GUARD) {
                        break;
                    }

                    g[y][x] = GUARDED;
                    x += dx;
                    y += dy;
                }
            }
        }

        int count = 0;
        for (int[] row : g) {
            for (int col : row) {
                if (col == UNGUARDED) {
                    count++;
                }
            }
        }
        return count;
    }
}
