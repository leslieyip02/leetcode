import java.util.*;

class Solution {
    public int minOperations(int[] nums, int k) {
      PriorityQueue<Long> smallest = new PriorityQueue<>();
      for (int num : nums) {
          smallest.add((long) num);
      }

      int operations = 0;
      while (smallest.peek() < k) {
          long x = smallest.poll();
          long y = smallest.poll();
          smallest.add(x * 2 + y);
          operations++;
      }
      return operations;
    }
}
