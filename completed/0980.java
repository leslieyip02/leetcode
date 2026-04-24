class Solution {
    private static final int[][] DIRECTIONS = {
        { 1, 0 },
        { -1, 0 },
        { 0, 1 },
        { 0, -1 },
    };

    private int dfs(
        int current,
        int ending,
        Map<Integer, List<Integer>> adjacencyLists,
        Set<Integer> yetToVisit
    ) {
        // 1. Exit condition
        if (current == ending) {
            return yetToVisit.size() == 1 && yetToVisit.contains(ending) ? 1 : 0;
        }

        // 2. Mark cell as visited
        yetToVisit.remove(current);

        // 3. Check the neighbors
        int count = 0;
        for (int adjacent : adjacencyLists.get(current)) {
            if (yetToVisit.contains(adjacent)) {
                count += dfs(adjacent, ending, adjacencyLists, yetToVisit);
            }
        }

        // 4. Reset
        yetToVisit.add(current);
        return count;
    }

    private int encodeSquareToIndex(int row, int col, int n) {
        return row * n + col;
    }

    public int uniquePathsIII(int[][] grid) {
        // This seems similar to Hamiltonian Path

        // 1. Set up graph
        int m = grid.length;
        int n = grid[0].length;
        int starting = -1;
        int ending = -1;
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
        Set<Integer> yetToVisit = new HashSet<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // Cannot walk over
                if (grid[row][col] == -1) {
                    continue;
                }

                int index = encodeSquareToIndex(row, col, n);
                if (grid[row][col] == 1) {
                    starting = index;
                }
                if (grid[row][col] == 2) {
                    ending = index;
                }
                yetToVisit.add(index);

                List<Integer> adjacencyList = new ArrayList<>();
                for (int[] direction : DIRECTIONS) {
                    int r1 = row + direction[0];
                    int c1 = col + direction[1];

                    // Out of bounds
                    if (r1 < 0 || r1 == m || c1 < 0 || c1 == n) {
                        continue;
                    }

                    // Cannot walk over
                    if (grid[r1][c1] == -1) {
                        continue;
                    }

                    adjacencyList.add(encodeSquareToIndex(r1, c1, n));
                }
                adjacencyLists.put(index, adjacencyList);
            }
        }

        // 2. Use DFS to go through all possible paths
        return dfs(starting, ending, adjacencyLists, yetToVisit);
    }
}
