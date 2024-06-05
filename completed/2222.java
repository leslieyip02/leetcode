class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        long[][][] ways = new long[3][2][n];
        for (int i = 0; i < n; i++) {
            int b = s.charAt(i) - 48;
            int c = b ^ 1;

            // start of new sequence
            ways[0][b][i]++;
            if (i == 0) {
                continue;
            }
            ways[0][b][i] += ways[0][b][i - 1];
            ways[0][c][i] += ways[0][c][i - 1];

            // 2nd building
            ways[1][b][i] += ways[0][c][i - 1];
            ways[1][b][i] += ways[1][b][i - 1];
            ways[1][c][i] += ways[1][c][i - 1];
            if (i == 1) {
                continue;
            }

            // 3rd building
            ways[2][b][i] = ways[1][c][i - 1];
            ways[2][b][i] += ways[2][b][i - 1];
            ways[2][c][i] += ways[2][c][i - 1];
        }
        return ways[2][0][n - 1] + ways[2][1][n - 1];
    }
}
