import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int n = 0;
        while (i < g.length && j < s.length) {
            if (s[j] < g[i]) {
                j++;
            } else {
                i++;
                j++;
                n++;
            }
        }
        return n++;
    }
}
