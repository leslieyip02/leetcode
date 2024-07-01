import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> multipliers = new Stack<>();
        Stack<StringBuilder> chunks = new Stack<>();
        chunks.push(new StringBuilder());
        chunks.push(new StringBuilder());

        int left = 0;
        while (left < s.length()) {
            char c = s.charAt(left);
            if (Character.isDigit(c)) {
                int right = left + 1;
                while (right < s.length() && Character.isDigit(s.charAt(right))) {
                    right++;
                }
                multipliers.push(Integer.parseInt(s.substring(left, right)));
                left = right;
            } else {
                if (c == '[') {
                    chunks.push(new StringBuilder());
                } else if (c == ']') {
                    String current = chunks.pop().toString(); 
                    int multiplier = multipliers.pop();
                    for (int i = 0; i < multiplier; i++) {
                        chunks.peek().append(current);
                    }
                } else {
                    chunks.peek().append(c);
                }
                left++;
            }
        }
        return chunks.pop().toString();
    }
}
