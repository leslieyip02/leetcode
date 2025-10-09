class Solution {
    public int maxProfit(int[] prices) {
        int[] prefixMax = new int[prices.length + 1];
        int lowest = (int) 1e6;
        for (int i = 0; i < prices.length; i++) {
            prefixMax[i + 1] = Math.max(prices[i] - lowest, prefixMax[i]);
            lowest = Math.min(prices[i], lowest);
        }

        int[] suffixMax = new int[prices.length + 1];
        int highest = -1;
        for (int i = prices.length - 1; i >= 0; i--) {
            suffixMax[i] = Math.max(highest - prices[i], suffixMax[i + 1]);
            highest = Math.max(prices[i], highest);
        }

        int best = 0;
        for (int i = 0; i < prices.length; i++) {
            best = Math.max(prefixMax[i + 1] + suffixMax[i], best);
        }
        return best;
    }
}
