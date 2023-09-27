import java.util.*;

class Solution {
    public String decodeAtIndex(String s, int k) {
        int i = 0;
        long n = 0;
        for (; n < k && i < s.length(); i++) {
            n = Character.isDigit(s.charAt(i))
                ? n * Character.getNumericValue(s.charAt(i))
                : n + 1;
        }

        i--;
        for (; i >= 0; i--) {
            if (Character.isDigit(s.charAt(i))) {
                n /= Character.getNumericValue(s.charAt(i));
                k %= n;
            } else {
                if (k == 0 || k == n) {
                    return s.charAt(i) + "";
                } 
                n--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "leet2code3";
        int k = 10;

        Solution solution = new Solution();
        System.out.println(solution.decodeAtIndex(s, k));
        System.out.println(solution.decodeAtIndex("czjkk9elaqwiz7s6kgvl4gjixan3ky7jfdg3kyop3husw3fm289thisef8blt7a7zr5v5lhxqpntenvxnmlq7l34ay3jaayikjps", 768077956));
    }
}
