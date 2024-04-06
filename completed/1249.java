import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> brackets = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                brackets.push(c);
                sb.append(c);
            } else if (c == ')') {
                if (!brackets.isEmpty()) {
                    brackets.pop();
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        int i = sb.length() - 1;
        while (!brackets.isEmpty()) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                brackets.pop();
            }
            i--;
        }
        return sb.toString();
    }
}
