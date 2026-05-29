class Solution {
    private boolean canPartitionPrefixSums(long[] prefixSums) {
        for (int i = 1; i < prefixSums.length - 1; i++) {
            long left = prefixSums[i];
            long right = prefixSums[prefixSums.length - 1] - left;
            if (left == right) {
                return true;
            }
        }
        return false;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long[] verticalPrefixSums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            verticalPrefixSums[i + 1] = verticalPrefixSums[i];
            for (int j = 0; j < m; j++) {
                verticalPrefixSums[i + 1] += grid[j][i];
            }
        }
        long[] horizontalPrefixSums = new long[m + 1];
        for (int i = 0; i < m; i++) {
            horizontalPrefixSums[i + 1] = horizontalPrefixSums[i];
            for (int j = 0; j < n; j++) {
                horizontalPrefixSums[i + 1] += grid[i][j];
            }
        }

        return canPartitionPrefixSums(verticalPrefixSums)
            || canPartitionPrefixSums(horizontalPrefixSums);
    }
}
