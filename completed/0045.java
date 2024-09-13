import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int end = 0;
        int furthest = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(i + nums[i], furthest);
            if (furthest >= nums.length - 1) {
                return jumps + 1;
            }
            if (i == end) {
                end = furthest;
                jumps++;
            }
        }
        return jumps;
    }
}
