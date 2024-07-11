import java.util.*;

class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> segments = new Stack<>();
        segments.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                segments.push(new StringBuilder());
            } else if (c == ')') {
                StringBuilder current = segments.pop();
                segments.peek().append(current.reverse().toString());
            } else {
                segments.peek().append(c);
            }
        }
        return segments.pop().toString();
    }
}
