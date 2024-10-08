import java.util.*;

class Solution {
    public int minSwaps(String s) {
        char[] brackets = s.toCharArray();
        int open = 0;
        int close = 0;
        int swaps = 0;
        int right = brackets.length;
        for (int i = 0; i < brackets.length; i++) {
            if (brackets[i] == '[') {
                open++;
            } else {
                close++;
            }

            if (close > open) {
                right--;
                while (brackets[right] != '[') {
                    right--;
                }
                brackets[right] = ']';
                open++;
                close--;
                swaps++;
            }
        }
        return swaps;
    }
}
