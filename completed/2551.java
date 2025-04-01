class Solution {
    public long putMarbles(int[] weights, int k) {
        int[] adjacentSums = new int[weights.length - 1];
        for (int i = 0; i < weights.length - 1; i++) {
            adjacentSums[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(adjacentSums);

        long difference = 0;
        for (int i = 0; i < k - 1; i++) {
            difference -= adjacentSums[i];
            difference += adjacentSums[adjacentSums.length - i - 1];
        }
        return difference;
    }
}
