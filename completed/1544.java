import java.util.*;

class Solution {
    public String makeGood(String s) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (letters.isEmpty()) {
                letters.push(current);
                continue;
            }

            char top = letters.peek();
            if (Character.toUpperCase(top) == Character.toUpperCase(current) &&
                Character.isUpperCase(top) != Character.isUpperCase(current)) {
                letters.pop();
            } else {
                letters.push(current);
            }
        }

        char[] value = new char[letters.size()];
        while (!letters.isEmpty()) {
            value[letters.size() - 1] = letters.pop();
        }
        return new String(value);
    }
}
