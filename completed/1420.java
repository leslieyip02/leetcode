class Solution {
    private static final int M = (int) 1e9 + 7;

    private static int modMultiply(int a, int b) {
        int result = 0;
        while (b != 0) {
            if (b % 2 == 1) {
                result = (int) ((long) (result + a) % Solution.M);
            }

            a = (int) ((long) (2 * a) % Solution.M);
            b >>= 1;
        }
        return result;
    }

    public int numOfArrays(int n, int m, int k) {
        if (k == 0 || k > m) {
            return 0;
        }

        int dp[][][] = new int[n][m + 1][k + 1];
        // ways to get cost = 1 at first index
        for (int i = 1; i <= m; i++) {
            dp[0][i][1] = i;
        }

        for (int a = 1; a < n; a++) {
            for (int b = 1; b <= m; b++) {
                for (int c = 1; c <= k; c++) {
                    // same search cost by using previous index
                    for (int i = 1; i <= b; i++) {
                        int d = dp[a - 1][i][c] - dp[a - 1][i - 1][c];
                        if (d < 0) {
                            d += Solution.M;
                        }
                        dp[a][b][c] += + Solution.modMultiply(d, i);
                        dp[a][b][c] %= Solution.M;
                    }

                    // increase search cost by picking a new max
                    for (int i = 0; i < b; i++) {
                        dp[a][b][c] += dp[a - 1][i][c - 1];
                        dp[a][b][c] %= Solution.M;
                    }
                }
            }
        }
        return dp[n - 1][m][k];
    }

    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int k = 1;

        Solution solution = new Solution();
        System.out.println(solution.numOfArrays(n, m, k));
        System.out.println(solution.numOfArrays(50, 100, 25));
        System.out.println(solution.numOfArrays(37, 17, 7));
    }
}
