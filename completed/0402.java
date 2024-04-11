import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> digits = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            while (!digits.empty() && digit < digits.peek() && k > 0) {
                digits.pop();
                k--;
            }
            digits.push(digit);
        }
        while (!digits.empty() && k > 0) {
            digits.pop();
            k--;
        }
        int[] removed = new int[digits.size()];
        for (int i = digits.size() - 1; i >= 0; i--) {
            removed[i] = digits.pop();
        }
        int index = 0;
        while (index < removed.length && removed[index] == 0) {
            index++;
        }
        if (index >= removed.length) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = index; i < removed.length; i++) {
            sb.append(removed[i]);
        }
        return sb.toString();
    }
}
