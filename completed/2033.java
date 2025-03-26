class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int[] flattened = new int[m * n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                flattened[i * n + j] = grid[i][j];
            }
        }
        Arrays.sort(flattened);

        int median = flattened[m * n / 2];
        int ops = 0;
        for (int num : flattened) {
            if (num % x != median % x) {
                return -1;
            }
            ops += Math.abs(median - num) / x;
        }
        return ops;
    }
}
