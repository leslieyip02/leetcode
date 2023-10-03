import java.util.HashMap;

class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int num : nums) {
            f.put(num, f.getOrDefault(num, 0) + 1);
        }
        int n = 0;
        for (int v : f.values()) {
            if (v >= 2) {
                n += v * (v - 1) / 2;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 3 };

        Solution solution = new Solution();
        System.out.println(solution.numIdenticalPairs(nums));
    }
}
