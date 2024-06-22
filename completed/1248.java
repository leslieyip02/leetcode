class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> previous = new HashMap<>();
        int current = 0;
        int count = 0;
        for (int num : nums) {
            previous.put(current, previous.getOrDefault(current, 0) + 1);
            current += num % 2;
            if (current >= k) {
                count += previous.getOrDefault(current - k, 0);
            }
        }
        return count;
    }
}
