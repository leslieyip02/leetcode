import java.util.*;

class Solution {
    private int take(int[] suffixSums, int currentIndex, int M, int[][] memo) {
        int n = suffixSums.length;

        // able to take everything
        if (currentIndex + 2 * M >= n) {
            return suffixSums[currentIndex];
        }

        // already visited
        if (memo[currentIndex][M] != 0) {
            return memo[currentIndex][M];
        }

        // find minimum possible stones for the next player
        int next = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * M; i++) {
            // other player will try to maximise as well
            int taken = take(suffixSums, currentIndex + i, Math.max(i, M), memo);
            next = Math.min(taken, next);
        }
        memo[currentIndex][M] = suffixSums[currentIndex] - next;
        return memo[currentIndex][M];
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[] suffixSums = new int[n];
        suffixSums[n - 1] = piles[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSums[i] = suffixSums[i + 1] + piles[i];
        }

        int[][] memo = new int[n][n];
        return take(suffixSums, 0, 1, memo);
    }
}
