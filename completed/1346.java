import java.util.*;

class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            if (seen.contains(num * 2)) {
                return true;
            }
            if (num % 2 == 0 && seen.contains(num / 2)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
