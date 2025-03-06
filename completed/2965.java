class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        boolean[] found = new boolean[n * n];
        int[] ans = new int[2];
        int sum = 0;
        for (int[] row : grid) {
            for (int num : row) {
                if (found[num - 1]) {
                    ans[0] = num;
                } else {
                    found[num - 1] = true;
                    sum += num;
                }
            }
        }
        int expectedSum = (n * n + 1) * (n * n) / 2;
        ans[1] = expectedSum - sum;
        return ans;
    }
}
