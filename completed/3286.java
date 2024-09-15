import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{
        { 1, 0 },
        { 0, 1 },
        { -1, 0 },
        { 0, -1 },
    };

    private void visit(int x, int y, List<List<Integer>> grid, int[][] best) {
        for (int[] direction : DIRECTIONS) {
            int x1 = x + direction[0];
            int y1 = y + direction[1];
            if (x1 < 0 || x1 >= best[0].length ||
                y1 < 0 || y1 >= best.length) {
                continue;
            }

            int health = best[y][x];
            if (grid.get(y1).get(x1) == 1) {
                health--;
            }
            if (health > best[y1][x1]) {
                best[y1][x1] = health;
                visit(x1, y1, grid, best);
            }
        }
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] best = new int[m][n];
        best[0][0] = health;
        if (grid.get(0).get(0) == 1) {
            best[0][0]--;
        }
        visit(0, 0, grid, best);
        return best[m - 1][n - 1] != 0;
    }
}
