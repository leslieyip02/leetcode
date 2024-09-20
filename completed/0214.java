import java.util.*;

class Solution {
    public String shortestPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (right >= 0) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
            }
            right--;
        }

        // is palindrome
        if (left == s.length()) {
            return s;
        }

        // non palindrome suffix
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(left));
        sb = sb.reverse();

        // palindrome prefix
        sb.append(shortestPalindrome(s.substring(0, left)));
        sb.append(s.substring(left));
        return sb.toString();
    }
}
