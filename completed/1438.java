class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0;
        int right = 1;
        int longest = 1;
        TreeMap<Integer, Integer> current = new TreeMap<>();
        current.put(nums[left], 1);
        while (right < nums.length) {
            current.put(nums[right], current.getOrDefault(nums[right], 0) + 1);

            int min = current.firstKey();
            int max = current.lastKey();

            while (left < right && Math.abs(max - min) > limit) {
                current.put(nums[left], current.get(nums[left]) - 1);
                if (current.get(nums[left]) == 0) {
                    current.remove(nums[left]);
                }

                min = current.firstKey();
                max = current.lastKey();
                left++;
            }

            right++;
            longest = Math.max(right - left, longest);
        }
        return longest;
    }
}
