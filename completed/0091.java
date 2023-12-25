import java.util.*;

class Solution {
    private HashMap<Integer, Integer> memo;

    private int search(String s) {
        int n = s.length();
        if (this.memo.containsKey(n)) {
            return this.memo.get(n);
        }

        int num = 0;
        if (s.charAt(0) != '0') {
            num += this.search(s.substring(1));
            if (Integer.parseInt(s.substring(0, 2)) <= 26) {
                num += this.search(s.substring(2));
            }
        }
        this.memo.put(n, num);
        return num;
    }

    public int numDecodings(String s) {
        this.memo = new HashMap<>();
        if (s.charAt(0) == '0') {
            return 0;
        }
        this.memo.put(0, 1);
        this.memo.put(1, s.charAt(s.length() - 1) == '0' ? 0 : 1);
        return this.search(s);
    }
}
