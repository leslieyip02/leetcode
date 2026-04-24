class Solution {

    private boolean isInRange(int[] b1, int[] b2) {
        int x1 = b1[0];
        int y1 = b1[1];
        int x2 = b2[0];
        int y2 = b2[1];

        long dx = x1 - x2;
        long dy = y1 - y2;
        long r = b1[2];
        return dx * dx + dy * dy <= r * r;
    }

    private int detonateHelper(int from, int[][] bombs, boolean[] isDetonated) {
        isDetonated[from] = true;

        int count = 1;
        for (int i = 0; i < bombs.length; i++) {
            if (isDetonated[i] || !isInRange(bombs[from], bombs[i])) {
                continue;
            }
            count += detonateHelper(i, bombs, isDetonated);
        }
        return count;
    }

    private int detonate(int from, int[][] bombs) {
        return detonateHelper(from, bombs, new boolean[bombs.length]);
    }

    public int maximumDetonation(int[][] bombs) {
        int maximumCount = 1;
        for (int i = 0; i < bombs.length; i++) {
            maximumCount = Math.max(detonate(i, bombs), maximumCount);
        }
        return maximumCount;
    }
}
