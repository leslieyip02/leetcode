import java.util.*

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder digits = new StringBuilder();
        int m = a.length();
        int n = b.length();
        int c = 0;
        for (int i = 0; i < Math.max(m, n); i++) {
            int sum = c;
            if (i < m && a.charAt(m - i - 1) == '1') {
                sum++;
            }
            if (i < n && b.charAt(n - i - 1) == '1') {
                sum++;
            }
            digits.append((char) (sum % 2 + '0'));
            c = sum >= 2 ? 1 : 0;
        }
        if (c == 1) {
            digits.append('1');
        }
        return digits.reverse().toString();
    }
}
