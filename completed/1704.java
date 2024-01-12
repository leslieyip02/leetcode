import java.util.*;

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length() / 2;
        int left = 0;
        int right = 0;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        for (int i = 0; i < n; i++) {
            if (vowels.contains(Character.toLowerCase(s.charAt(i)))) {
                left++;
            }
            if (vowels.contains(Character.toLowerCase(s.charAt(i + n)))) {
                right++;
            }
        }
        return left == right;
    }
}
