import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> counts = new HashMap<>();

        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 0) {
                sum += k * (1 - (sum / k));
            }
            int mod = sum % k;
            counts.put(mod, counts.getOrDefault(mod, 0) + 1);
        }

        int total = counts.getOrDefault(0, 0);
        for (int count : counts.values()) {
            // n choose 2
            total += count * (count - 1) / 2;
        }
        return total;
    }
}
