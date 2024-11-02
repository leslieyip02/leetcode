import java.util.*;

class Solution {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String current = words[i];
            String next = words[(i + 1) % words.length];
            if (current.charAt(current.length() - 1) != next.charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
