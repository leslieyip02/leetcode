class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                for (var direction : directions) {
                    int p = i + direction[0];
                    int q = j + direction[1];
                    if (p < 0 || p >= grid.length ||
                        q < 0 || q >= grid[i].length ||
                        grid[p][q] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}
