import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        int operations = 0;
        for (int count : counts.values()) {
            if (count == 1) {
                return -1;
            }

            switch (count % 3) {
                case 0:
                    operations += count / 3;
                    break;
                case 1:
                case 2:
                    operations += count / 3 + 1;
                    break;
            }
        }
        return operations;
    }
}
