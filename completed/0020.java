import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> current = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                current.push(c);
            } else {
                if (current.empty()) {
                    return false;
                }

                char d = current.peek();
                if ((c == ')' && d != '(') ||
                    (c == ']' && d != '[') ||
                    (c == '}' && d != '{')) {
                    return false;
                }
                current.pop();
            }
        }
        return current.empty();
    }

    public static void main(String[] args) {
        String s = "()[]{}";

        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
