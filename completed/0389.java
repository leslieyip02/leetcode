import java.util.*;

class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int v = counts.getOrDefault(c, 0) + 1;
            counts.put(c, v);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            int v = counts.getOrDefault(c, 0);
            if (v == 0) {
                return c;
            }
            counts.put(c, v - 1);
        }
        return 'a';
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";

        Solution solution = new Solution();
        System.out.println(solution.findTheDifference(s, t));
    }
}
