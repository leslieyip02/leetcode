class Solution {
    public int heightChecker(int[] heights) {
        int[] buckets = new int[101];
        for (int height : heights) {
            buckets[height]++;
        }

        int bucket = 1;
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            while (buckets[bucket] == 0) {
                bucket++;
            }
            if (heights[i] != bucket) {
                count++;
            }
            buckets[bucket]--;
        }
        return count;
    }
}
