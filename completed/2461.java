import java.util.*;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maximum = 0;
        long currentSum = 0;
        Map<Integer, Integer> currentNums = new HashMap<>();
        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
            currentNums.put(nums[i], currentNums.getOrDefault(nums[i], 0) + 1);
        }
        if (currentNums.keySet().size() == k) {
            maximum = currentSum;
        }

        for (int i = k; i < nums.length; i++) {
            currentSum -= nums[i - k];
            int count = currentNums.get(nums[i - k]);
            if (count == 1) {
                currentNums.remove(nums[i - k]);
            } else {
                currentNums.put(nums[i - k], count - 1);
            }

            currentSum += nums[i];
            currentNums.put(nums[i], currentNums.getOrDefault(nums[i], 0) + 1);
            if (currentNums.keySet().size() == k) {
                maximum = Math.max(currentSum, maximum);
            }
        }
        return maximum;
    }
}
