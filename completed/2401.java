class Solution {
    private boolean isNice(int[] counts) {
        for (int count : counts) {
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int longest = 0;
        int[] counts = new int[32];
        while (right < nums.length) {
            for (int i = 0; i < 32; i++) {
                if (((1 << i) & nums[right]) != 0) {
                    counts[i]++;
                }
            }
            right++;

            while (!isNice(counts)) {
                for (int i = 0; i < 32; i++) {
                    if (((1 << i) & nums[left]) != 0) {
                        counts[i]--;
                    }
                }
                left++;
            }
            longest = Math.max(right - left, longest);
        }
        return longest;
    }
}
