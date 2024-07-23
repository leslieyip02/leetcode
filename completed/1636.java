import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }

        Object[] t = Arrays.stream(nums)
            .boxed()
            .sorted((a, b) -> {
                int c = f.get(a);
                int d = f.get(b);
                return c == d ? b - a : c - d;
            })
            .toArray();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) t[i];
        }
        return nums;
    }
}
