import java.util.*

class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> window = new TreeMap<>();

        int left = 0;
        long total = 0;
        for (int right = 0; right < nums.length; right++) {
            window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);

            while (window.lastKey() - window.firstKey() > 2) {
                window.put(nums[left], window.getOrDefault(nums[left], 0) - 1);
                if (window.get(nums[left]) == 0) {
                    window.remove(nums[left]);
                }
                left++;
            }

            total += right - left + 1;
        }
        return total;
    }
}
