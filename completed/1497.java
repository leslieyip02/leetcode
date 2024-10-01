import java.util.*;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainders = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int remainder = Math.floorMod(arr[i], k);
            remainders.put(remainder, remainders.getOrDefault(remainder, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : remainders.entrySet()) {
            int remainder = entry.getKey();
            int count = entry.getValue();
            int complement = (k - remainder) % k;
            if (remainders.getOrDefault(complement, -1) != count) {
                return false;
            }
            if (complement == remainder && count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
