class Solution {
    public int largestCombination(int[] candidates) {
        int[] counts = new int[32];
        for (int candidate : candidates) {
            int bit = 0;
            while (candidate > 0) {
                if ((candidate & 1) == 1) {
                    counts[bit]++;
                }
                candidate >>= 1;
                bit++;
            }
        }
        int largest = 0;
        for (int count : counts) {
            largest = Math.max(count, largest);
        }
        return largest;
    }
}
