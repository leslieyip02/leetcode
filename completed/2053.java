import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Boolean> distinct = new HashMap<>();
        for (String s : arr) {
            if (!distinct.containsKey(s)) {
                distinct.put(s, true);
            } else {
                distinct.put(s, false);
            }
        }

        for (String s : arr) {
            if (distinct.get(s)) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }
        return "";
    }
}
