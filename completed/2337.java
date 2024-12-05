import java.util.*;

class Solution {
    public boolean canChange(String start, String target) {
        int l = 0;
        int r = 0;
        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == 'L') {
                if (r > 0) {
                    return false;
                }
                l++;
            } else if (target.charAt(i) == 'R') {
                r--;
            }
            if (start.charAt(i) == 'R') {
                if (l > 0) {
                    return false;
                }
                r++;
            } else if (start.charAt(i) == 'L') {
                l--;
            }
            if (l < 0 || r < 0) {
                return false;
            }
        }
        return l == 0 && r == 0;
    }
}
