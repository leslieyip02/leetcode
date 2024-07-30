import java.util.*;

class Solution {
    public int minimumDeletions(String s) {
        int a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a++;
            }
        }

        int b = 0;
        int deletions = s.length();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                a--;
            }

            deletions = Math.min(a + b, deletions);

            if (s.charAt(i) == 'b') {
                b++;
            }
        }
        return deletions;
    }
}
