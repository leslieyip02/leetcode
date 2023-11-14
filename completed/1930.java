import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        HashMap<Character, Integer> left = new HashMap<>();
        HashMap<Character, Integer> right = new HashMap<>();
        left.put(s.charAt(0), 1);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            right.put(c, right.getOrDefault(c, 0) + 1);
        }

        HashSet<String> palindromes = new HashSet<>();
        for (int i = 1; i < s.length() - 1; i++) {
            Character current = s.charAt(i);
            right.put(current, right.get(current) - 1);
            for (Character c : left.keySet()) {
                String palindrome = "" + c + current + c;
                if (palindromes.contains(palindrome)) {
                    continue;
                }
                if (right.getOrDefault(c, 0) > 0) {
                    palindromes.add(palindrome);
                }
            }
            left.put(current, left.getOrDefault(current, 0) + 1);
        }
        return palindromes.size();
    }

    public static void main(String[] args) {
        String s = "bbcbaba";

        Solution solution = new Solution();
        System.out.println(solution.countPalindromicSubsequence(s));
    }
}
