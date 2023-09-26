import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> indices = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indices.put(s.charAt(i), i);
        }

        Stack<Character> letters = new Stack<>();
        HashSet<Character> included = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (!included.contains(x)) {
                if (!letters.isEmpty()) {
                    char y = letters.peek();
                    while (y > x && indices.get(y) > i) {
                        included.remove(y);
                        letters.pop();
                        if (letters.isEmpty()) {
                            break;
                        }
                        y = letters.peek();
                    }
                }
                letters.push(x);
                included.add(x);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!letters.isEmpty()) {
            sb.append(letters.peek());
            letters.pop();
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";

        Solution solution = new Solution();
        System.out.println(solution.removeDuplicateLetters(s));
        System.out.println(solution.removeDuplicateLetters("cbacdcb"));
        System.out.println(solution.removeDuplicateLetters("bcabc"));
    }
}
