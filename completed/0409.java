import java.util.*;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> f = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            f.put(c, f.getOrDefault(c, 0) + 1);
        }

        int single = 0;
        int pairs = 0;
        for (int i : f.values()) {
            single |= i % 2;
            pairs += i / 2;
        }
        return single + pairs * 2;
    }
}
