import java.util.*;

class Solution {
    private String backspace(String s) {
        Stack<Character> result = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (!result.isEmpty()) {
                    result.pop();
                }
            } else {
                result.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }

    public boolean backspaceCompare(String s, String t) {
        return this.backspace(s).compareTo(this.backspace(t)) == 0;
    }

    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";

        Solution solution = new Solution();
        System.out.println(solution.backspaceCompare(s, t));
    }
}
