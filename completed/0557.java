import java.util.*;

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String[] reversed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = words[i].length() - 1; j >= 0; j--) {
                sb.append(words[i].charAt(j));
            }
            reversed[i] = sb.toString();
        }
        return String.join(" ", reversed);
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";

        Solution solution = new Solution();
        System.out.println(solution.reverseWords(s));
    }
}
