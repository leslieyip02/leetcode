import java.util.*;

class Solution {
    public int maxResult(int[] nums, int k) {
        int[] scores = new int[nums.length];
        PriorityQueue<Integer> indices = new PriorityQueue<>((i, j) -> scores[j] - scores[i]);
        for (int i = 0; i < nums.length; i++) {
            scores[i] = nums[i];
            if (!indices.isEmpty()) {
                while (indices.peek() < i - k) {
                    indices.poll();
                }
                scores[i] += scores[indices.peek()]; 
            }
            indices.add(i);
        }
        return scores[nums.length - 1];
    }
}
