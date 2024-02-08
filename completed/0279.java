import java.util.*;

class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            squares.add(square);
            dp[square] = 1;
        }

        for (int i = 2; i <= n; i++) {
            int m = i;
            for (int square : squares) {
                if (square > i) {
                    break;
                }
                dp[i] = Math.min(m / square + dp[m % square], dp[i]);
            }
        }
        return dp[n];
    }
}
