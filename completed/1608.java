import java.util.*;

class Solution {
    public int specialArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }

        int minimum = -1;
        while (!pq.isEmpty()) {
            int current = pq.poll();
            int count = 1;
            while (!pq.isEmpty() && pq.peek() == current) {
                pq.poll();
                count++;
            }

            int x = count + pq.size();
            if (current >= x && x > minimum) {
                return x;
            }
            minimum = current;
        }
        return -1;
    }
}
