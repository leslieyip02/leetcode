import java.util.*;

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int sum = 0;
        PriorityQueue<Integer> largest = new PriorityQueue<>();
        for (int i = 0; i < heights.length - 1; i++) {
            int gap = heights[i + 1] - heights[i];
            if (gap <= 0) {
                continue;
            }

            if (largest.size() < ladders) {
                largest.add(gap);
            } else if (!largest.isEmpty() && gap > largest.peek()) {
                    sum += largest.poll();
                    largest.add(gap);
            } else {
                sum += gap;
            }
            if (sum > bricks) {
                return i;
            }
        }
        return heights.length - 1;
    }
}
