import java.util.*;

class Solution {
    public String clearDigits(String s) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (Character.isDigit(letter)) {
                if (!letters.empty()) {
                    letters.pop();
                }
            } else {
                letters.push(letter);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!letters.empty()) {
            result.append(letters.pop());
        }
        return result.reverse().toString();
    }
}
