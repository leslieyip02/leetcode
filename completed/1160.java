import java.util.*;

class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            d.put(c, d.getOrDefault(c, 0) + 1);
        }

        int t = 0;
        HashMap<Character, Integer> f = new HashMap<>();
        for (String word : words) {
            boolean ok = true;
            f.clear();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                f.put(c, f.getOrDefault(c, 0) + 1);
            }
            for (Character k : f.keySet()) {
                if (!d.containsKey(k) || f.get(k) > d.get(k)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                t += word.length();
            }
        }
        return t;
    }

    public static void main(String[] args) {
        String[] words = { "cat", "bt", "hat", "tree" };
        String chars = "atach";

        Solution solution = new Solution();
        System.out.println(solution.countCharacters(words, chars));
    }
}
