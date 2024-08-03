import java.util.*;

class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> present = new HashMap<>();
        for (int num : target) {
            present.put(num, present.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {
            if (!present.containsKey(num)) {
                return false;
            }
            present.put(num, present.get(num) - 1);
            if (present.get(num) == 0) {
                present.remove(num);
            }
        }
        return true;
    }
}
