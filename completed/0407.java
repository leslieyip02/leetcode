import java.util.*

class Solution {
    static final int[][] DIRECTIONS = new int[][]{ { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    class Cell implements Comparable<Cell> {
        int row;
        int col;
        int height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }

        @Override
        public int compareTo(Cell other) {
            return height - other.height;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<Cell> boundary = new PriorityQueue<>();
        boolean[][] isVisited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            boundary.add(new Cell(i, 0, heightMap[i][0]));
            boundary.add(new Cell(i, n - 1, heightMap[i][n - 1]));
            isVisited[i][0] = true;
            isVisited[i][n - 1] = true;
        }
        for (int i = 1; i < n - 1; i++) {
            boundary.add(new Cell(0, i, heightMap[0][i]));
            boundary.add(new Cell(m - 1, i, heightMap[m - 1][i]));
            isVisited[0][i] = true;
            isVisited[m - 1][i] = true;
        }

        int volume = 0;
        while (!boundary.isEmpty()) {
            Cell current = boundary.poll();
            int minimumHeight = current.height;
            for (int[] direction : DIRECTIONS) {
                int r1 = current.row + direction[0];
                int c1 = current.col + direction[1];
                if (r1 < 0 || r1 >= m || c1 < 0 || c1 >= n || isVisited[r1][c1]) {
                    continue;
                }

                if (heightMap[r1][c1] < minimumHeight) {
                    volume += minimumHeight - heightMap[r1][c1];
                }
                boundary.add(new Cell(r1, c1, Math.max(heightMap[r1][c1], minimumHeight)));
                isVisited[r1][c1] = true;
            }
        }
        return volume;
    }
}
