class Solution {
    private static final long IMPOSSIBLE = (long) -1e10;

    private long[][] memo;

    private long choose(int[] a, int[] b, int aIndex, int bIndex) {
        if (aIndex >= a.length) {
            return 0;
        }
        if (bIndex >= b.length) {
            return IMPOSSIBLE;
        }
        if (memo[aIndex][bIndex] != IMPOSSIBLE) {
            return memo[aIndex][bIndex];
        }

        long best = Math.max(
            (long) a[aIndex] * b[bIndex] + choose(a, b, aIndex + 1, bIndex + 1),
            choose(a, b, aIndex, bIndex + 1)
        );
        memo[aIndex][bIndex] = best;
        return best;
    }

    public long maxScore(int[] a, int[] b) {
        memo = new long[a.length][b.length];
        for (int i = 0 ; i < a.length; i++) {
            Arrays.fill(memo[i], IMPOSSIBLE);
        }
        return choose(a, b, 0, 0);
    }
}
