import java.util.*;

class Solution {
    public int maximumSwap(int num) {
        String s = num + "";
        int[] digits = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            digits[i] = (int) s.charAt(i) - '0';
        }

        // find min
        int[] prefixIndices = new int[digits.length];
        for (int i = 1; i < digits.length; i++) {
            prefixIndices[i] = digits[i] < digits[prefixIndices[i - 1]] ? i : prefixIndices[i - 1];
        }

        int[] suffixIndices = new int[digits.length];
        suffixIndices[digits.length - 1] = digits.length - 1;
        for (int i = digits.length - 2; i >= 0; i--) {
            suffixIndices[i] = digits[i] > digits[suffixIndices[i + 1]] ? i : suffixIndices[i + 1];
        }

        int max = num;
        for (int i = 0; i < digits.length; i++) {
            StringBuilder sb = new StringBuilder();
            int from = prefixIndices[i];
            int to = suffixIndices[i];
            for (int j = 0; j < digits.length; j++) {
                int index = j == from ? to : j == to ? from : j;
                sb.append(digits[index]);
            }
            max = Math.max(Integer.parseInt(sb.toString()), max);
        }
        return max;
    }
}
