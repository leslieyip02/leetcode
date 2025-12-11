class Solution {

    private boolean canFinish(int[] piles, int h, int k) {
        for (int pile : piles) {
            h -= (int) Math.ceil(pile / (double) k);
        }
        return h >= 0;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = (int) 1e9;
        while (low < high) {
            int k = (low + high) / 2;
            if (canFinish(piles, h, k)) {
                high = k;
            } else {
                low = k + 1;
            }
        }
        return low;
    }
}
