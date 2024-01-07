import java.util.*;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        Map<Long, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = (long) nums[i];
            if (!indices.containsKey(num)) {
                indices.put(num, new ArrayList<>());
            }
            indices.get(num).add(i);
        }

        int total = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                long diff = (long) nums[j] - nums[i];
                long prev = nums[i] - diff;
                if (indices.containsKey(prev)) {
                    for (int index : indices.get(prev)) {
                        if (index >= i) {
                            break;
                        }
                        dp[i][j] += dp[index][i] + 1;
                    }
                }
                total += dp[i][j];
            }
        }
        return total;
    }
}
