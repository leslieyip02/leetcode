class Solution {
    private final static int[][] directions = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 }
    };

    private int flood(int x0, int y0, int[][] grid) {
        grid[y0][x0] = 0;
        int area = 1;
        for (var direction : directions) {
            int x1 = x0 + direction[0];
            int y1 = y0 + direction[1];
            if (x1 >= 0 && x1 < grid[0].length &&
                y1 >= 0 && y1 < grid.length) {

                if (grid[y1][x1] == 1) {
                    area += flood(x1, y1, grid); 
                }
            }
        }
        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int m = 0;
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[0].length; x++) {
                if (grid[y][x] == 1) {
                    m = Math.max(flood(x, y, grid), m);
                }
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[][] grid = {
            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
            { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
        };

        Solution solution = new Solution();
        System.out.println(solution.maxAreaOfIsland(grid));
    }
}
