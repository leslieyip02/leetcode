import java.util.*;

class Solution {
    public int findTargetSumWays(int[] nums, int target) {    
        Map<Integer, Integer> ways = new HashMap<>();
        ways.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : ways.entrySet()) {
                int current = entry.getKey();
                int count = entry.getValue();
                tmp.put(current + num, tmp.getOrDefault(current + num, 0) + count);
                tmp.put(current - num, tmp.getOrDefault(current - num, 0) + count);
            }
            ways = tmp;
        }
        return ways.getOrDefault(target, 0);
    }
}
