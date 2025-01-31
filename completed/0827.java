import java.util.*;

class Solution {
    private int[][] directions = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private int visit(int r0, int c0, int[][] grid, int[][] groups) {
        int total = grid[r0][c0];
        for (int[] direction : directions) {
            int r1 = r0 + direction[0];
            int c1 = c0 + direction[1];
            if (r1 < 0 || r1 >= grid.length || c1 < 0 || c1 >= grid[r1].length) {
                continue;
            }

            if (groups[r1][c1] != 0 || grid[r1][c1] == 0) {
                continue;
            }
            groups[r1][c1] = groups[r0][c0];
            total += visit(r1, c1, grid, groups);
        }
        return total;
    }

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int largest = 0;

        int group = 1;
        int[][] groups = new int[n][n];
        Map<Integer, Integer> groupSizes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && groups[i][j] == 0) {
                    groups[i][j] = group;
                    int size = visit(i, j, grid, groups);
                    largest = Math.max(size, largest);
                    groupSizes.put(group, size);
                    group++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> adjacentGroups = new HashSet<>();
                    for (int[] direction : directions) {
                        int r1 = i + direction[0];
                        int c1 = j + direction[1];
                        if (r1 < 0 || r1 >= n || c1 < 0 || c1 >= n) {
                            continue;
                        }

                        adjacentGroups.add(groups[r1][c1]);
                    }

                    int total = 1;
                    for (int adj: adjacentGroups) {
                        if (adj == 0) {
                            continue;
                        }

                        total += groupSizes.get(adj);
                    }
                    largest = Math.max(total, largest);
                }
            }
        }
        return largest;
    }
}
