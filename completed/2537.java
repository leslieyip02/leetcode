class Solution {
    public long countGood(int[] nums, int k) {
        long total = 0;

        int pairs = 0;
        int left = 0;
        int right = 0;
        Map<Integer, Long> counts = new HashMap<>();
        while (left < nums.length) {
            while (right < nums.length && pairs < k) {
                long count = counts.getOrDefault(nums[right], 0L) + 1;
                counts.put(nums[right], count);
                if (count >= 2) {
                    pairs += count - 1;
                }
                right++;
            }

            if (pairs >= k) {
                total += nums.length - (right - 1);
            }

            long count = counts.get(nums[left]) - 1;
            counts.put(nums[left], count);
            pairs -= count;
            left++;
        }
        return total;
    }
}
