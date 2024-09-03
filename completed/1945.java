import java.util.*;

class Solution {
    public int getLucky(String s, int k) {
        List<Integer> digits = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int v = (int) s.charAt(i) - 'a' + 1;
            while (v > 0) {
                digits.add(v % 10);
                v /= 10;
            }
        }

        int result = 0;
        while (k > 0) {
            result = 0;
            for (int digit : digits) {
                result += digit;
            }
            if (k == 1) {
                break;
            }

            digits.clear();
            while (result > 0) {
                digits.add(result % 10);
                result /= 10;
            }
            k--;
        }
        return result;
    }
}
