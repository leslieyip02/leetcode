class Solution {
    public int maxProfit(int[] prices) {
        int best = 0;
        int lowest = (int) 1e5;
        for (int price : prices) {
            best = Math.max(price - lowest, best);
            lowest = Math.min(price, lowest);
        }
        return best;
    }
}
