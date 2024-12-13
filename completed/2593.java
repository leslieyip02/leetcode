import java.util.*;

class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Integer> indices = new PriorityQueue<>((a, b) -> nums[a] == nums[b] ? a - b : nums[a] - nums[b]);
        for (int i = 0; i < nums.length; i++) {
            indices.add(i);
        }

        boolean[] isMarked = new boolean[nums.length];
        long score = 0;
        while (!indices.isEmpty()) {
            int current = indices.poll();
            if (isMarked[current]) {
                continue;
            }

            score += nums[current];
            isMarked[current] = true;
            if (current - 1 >= 0) {
                isMarked[current - 1] = true;
            }
            if (current + 1 < nums.length) {
                isMarked[current + 1] = true;
            }
        }
        return score;
    }
}
