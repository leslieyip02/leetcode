import java.util.*;

class Solution {
    public String smallestSubsequence(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 97;
            count[index]++;
        }

        int current = 0;
        Stack<Integer> subsequence = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 97;
            count[index]--;
            if ((current & (1 << index)) != 0) {
                continue;
            }

            while (!subsequence.isEmpty()) {
                int last = subsequence.peek();
                if (count[last] == 0 || last < index) {
                    break;
                }
                subsequence.pop();
                current ^= (1 << last);
            }

            subsequence.push(index);
            current |= (1 << index);
        }

        StringBuilder result = new StringBuilder();
        while (!subsequence.isEmpty()) {
            int index = subsequence.pop();
            result.append((char) (index + 97));
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        // String s = "bcabc";
        String s = "cbacdcbc";

        Solution solution = new Solution();
        System.out.println(solution.smallestSubsequence(s));
    }
}
