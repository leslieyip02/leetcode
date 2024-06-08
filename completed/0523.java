import java.util.*;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }

        Map<Integer, Integer> previous = new HashMap<>();
        int sum = nums[0];
        int mod = sum % k;
        previous.put(mod, 0);
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            mod = sum % k;
            if (mod == 0) {
                return true;
            }

            if (previous.containsKey(mod)) {
                if (previous.get(mod) < i - 1) {
                    return true;
                }
            } else {
                previous.put(mod, i);
            }
        }
        return false;
    }
}
