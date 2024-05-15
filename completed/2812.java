import java.util.*;

class Solution {
    private final static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    private void updateSafeness(int[][] safeness, int row, int col) {
        int n = safeness.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int current = Math.abs(row - i) + Math.abs(col - j);
                safeness[i][j] = Math.min(current, safeness[i][j]);
            }
        }
    }

    private boolean search(int[][] safeness, int threshold) {
        int n = safeness.length;
        boolean[][] visited = new boolean[n][n];
        Queue<Integer[]> next = new LinkedList<>();
        next.add(new Integer[]{ 0, 0 });
        visited[0][0] = true;
        while (!next.isEmpty()) {
            var current = next.poll();
            int row = current[0];
            int col = current[1];
            if (row == n - 1 && col == n - 1) {
                break;
            }

            for (var dir : dirs) {
                int i = row + dir[0];
                int j = col + dir[1];
                if (i < 0 || i >= n || j < 0 || j >= n) {
                    continue;
                }

                if (safeness[i][j] < threshold || visited[i][j]) {
                    continue;
                }

                visited[i][j] = true;
                next.add(new Integer[]{ i, j });
            }
        }
        return visited[n - 1][n - 1];
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        int[][] safeness = new int[n][n];
        Queue<Integer[]> thieves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            var row = grid.get(i);
            for (int j = 0; j < n; j++) {
                if (row.get(j) == 1) {
                    thieves.add(new Integer[]{ i, j });
                } else {
                    safeness[i][j] = -1;
                }
            }
        }
        while (!thieves.isEmpty()) {
            int m = thieves.size();
            while (m > 0) {
                var current = thieves.poll();
                int row = current[0];
                int col = current[1];
                for (var dir : dirs) {
                    int i = row + dir[0];
                    int j = col + dir[1];
                    if (i < 0 || i >= n || j < 0 || j >= n) {
                        continue;
                    }

                    if (safeness[i][j] != -1) {
                        continue;
                    }

                    safeness[i][j] = safeness[row][col] + 1;
                    thieves.add(new Integer[]{ i, j });
                }
                m--;
            }
        }

        int left = 0;
        int right = safeness[0][0];
        int mid = (left + right) / 2;
        while (left < right) {
            if (search(safeness, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
            mid = (left + right + 1) / 2;
        }
        return mid;
    }
}
