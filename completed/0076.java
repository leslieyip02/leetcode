import java.util.*;

class Solution {
    private boolean isAllIncluded(HashMap<Character, Integer> target, HashMap<Character, Integer> included) {
        boolean ok = true;
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            char letter = entry.getKey();
            int f = entry.getValue();
            if (included.getOrDefault(letter, 0) < f) {
                ok = false;
                break;
            }
        }
        return ok;
    }

    public String minWindow(String s, String t) {
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            target.put(t.charAt(i), target.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        boolean possible = false;
        String minimum = String.valueOf(s);
        HashMap<Character, Integer> included = new HashMap<>();
        while (right < s.length()) {
            included.put(s.charAt(right), included.getOrDefault(s.charAt(right), 0) + 1);
            while (isAllIncluded(target, included)) {
                possible = true;
                String substring = s.substring(left, right + 1);
                if (substring.length() < minimum.length()) {
                    minimum = substring;
                }
                included.put(s.charAt(left), included.get(s.charAt(left)) - 1);
                left++;
            }
            right++;
        }
        return possible ? minimum : "";
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        Solution solution = new Solution();
        System.out.println(solution.minWindow(s, t));
        System.out.println(solution.minWindow("a", "a"));
        System.out.println(solution.minWindow("a", "aa"));
    }
}
