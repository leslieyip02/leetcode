class Solution {

    int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[] maxPoints(int[][] grid, int[] queries) {
        int rowCount = grid.length, colCount = grid[0].length;
        int[] result = new int[queries.length];

        int[][] sortedQueries = new int[queries.length][2];
        for (int index = 0; index < queries.length; index++) {
            sortedQueries[index][0] = queries[index];
            sortedQueries[index][1] = index;
        }
        Arrays.sort(sortedQueries, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );
        boolean[][] visited = new boolean[rowCount][colCount];
        int totalPoints = 0;
        minHeap.add(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;

        for (int[] query : sortedQueries) {
            int queryValue = query[0];
            int queryIndex = query[1];
            while (!minHeap.isEmpty() && minHeap.peek()[0] < queryValue) {
                int[] top = minHeap.poll();
                int cellValue = top[0];
                int currentRow = top[1];
                int currentCol = top[2];
                totalPoints++;

                for (int[] dir : DIRECTIONS) {
                    int newRow = currentRow + dir[0];
                    int newCol = currentCol + dir[1];

                    if (
                        newRow >= 0 &&
                        newCol >= 0 &&
                        newRow < rowCount &&
                        newCol < colCount &&
                        !visited[newRow][newCol]
                    ) {
                        minHeap.add(new int[] { grid[newRow][newCol], newRow, newCol });
                        visited[newRow][newCol] = true;
                    }
                }
            }
            result[queryIndex] = totalPoints;
        }
        return result;
    }
}
