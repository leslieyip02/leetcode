class Solution {

    Random rng;
    int[] prefixSum;

    public Solution(int[] w) {
        rng = new Random();

        prefixSum = new int[w.length + 1];
        for (int i = 0; i < w.length; i++) {
            prefixSum[i + 1] = w[i] + prefixSum[i];
        }
    }
    
    public int pickIndex() {
        int target = (int) (rng.nextDouble() * prefixSum[prefixSum.length - 1]);

        int left = 1;
        int right = prefixSum.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (prefixSum[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
