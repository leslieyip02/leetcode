import java.util.*;

class Solution {
    public boolean isCyclicMatch(char c1, char c2) {
        int a1 = (int) c1 - 97;
        int a2 = (int) c2 - 97;
        return a1 == a2 || ((a1 + 1) % 26) == a2;
    }

    public boolean canMakeSubsequence(String str1, String str2) {
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length()) {
            if (isCyclicMatch(str1.charAt(i1), str2.charAt(i2))) {
                i2++;
                if (i2 == str2.length()) {
                    return true;
                }
            }
            i1++;
        }
        return false;
    }
}
