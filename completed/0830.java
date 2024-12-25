import java.util.*;

class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> groups = new ArrayList<>();
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (s.charAt(right) != s.charAt(left)) {
                if (right - left >= 3) {
                    groups.add(List.of(left, right - 1));
                }
                left = right;
            } else {
                right++;
            }
        }
        if (right - left >= 3) {
            groups.add(List.of(left, right - 1));
        }
        return groups;
    }
}
