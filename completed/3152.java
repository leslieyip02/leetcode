import java.util.*;

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] groups = new int[nums.length];
        groups[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 != nums[i - 1] % 2) {
                groups[i] = groups[i - 1];
            } else {
                groups[i] = groups[i - 1] + 1;
            }
        }

        boolean[] answer = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            answer[i] = groups[from] == groups[to];
        }
        return answer;
    }
}
