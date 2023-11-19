import java.util.*;

class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        int i = 0;
        int operations = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (i == 0) {
                i++;
                continue;
            }
            operations += i * entry.getValue();
            i++;
        }
        return operations;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 3 };

        Solution solution = new Solution();
        System.out.println(solution.reductionOperations(nums));
    }
}
