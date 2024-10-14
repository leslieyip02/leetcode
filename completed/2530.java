import java.util.*;

class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : nums) {
            maxHeap.add(num);
        }

        long score = 0;
        for (int i = 0; i < k; i++) {
            int current = maxHeap.poll();
            score += current;
            maxHeap.add((int) Math.ceil(current / 3.0));
        }
        return score;
    }
}
