class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
		long[] prefixSums = new long[prices.length + 1];
		for (int i = 0; i < prices.length; i++) {
			prefixSums[i + 1] = prefixSums[i] + prices[i] * strategy[i];
        }

		// set original strategy as initial maximum
		long maximum = prefixSums[prices.length];
		for (int i = 0; i < prefixSums.length - k; i++) {
			long left = prefixSums[i];
			long right = prefixSums[prices.length] - prefixSums[i + k];
			long newSum = left + right;
			for (int j = k / 2; j < k; j++) {
				newSum += prices[i + j];
            }
            maximum = Math.max(newSum, maximum);
        }
        return maximum;
    }
}

