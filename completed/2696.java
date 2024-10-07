import java.util.*;

class Solution {
    public int minLength(String s) {
        Stack<Character> letters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (letters.empty()) {
                letters.push(current);
                continue;
            }

            if ((letters.peek() == 'A' && current == 'B') ||
                (letters.peek() == 'C' && current == 'D')) {
                letters.pop();
                continue;
            }
            letters.push(current);
        }
        return letters.size();
    }
}
