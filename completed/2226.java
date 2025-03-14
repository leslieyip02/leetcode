class Solution {
    private boolean ok(int[] candies, long k, int size) {
        long piles = 0;
        for (int candy : candies) {
            piles += candy / size;
        }
        return piles >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int lower = 0;
        int upper = 0;
        for (int candy : candies) {
            upper = Math.max(candy, upper);
        }

        while (lower < upper) {
            int mid = (lower + upper + 1) / 2;
            if (ok(candies, k, mid)) {
                lower = mid;
            } else {
                upper = mid - 1;
            }
        }
        return lower;
    }
}
