import java.util.*;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }
        int n = nums.length;
        int t = n / 3;
        List<Integer> m = new ArrayList<>();
        for (Map.Entry entry : f.entrySet()) {
            if ((int) entry.getValue() > t) {
                m.add((int) entry.getKey());
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };

        Solution solution = new Solution();
        var result = solution.majorityElement(nums);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
