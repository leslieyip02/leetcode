import java.util.*;

class Solution {
    private StringBuilder add(StringBuilder comp, char c, int count) {
        while (count > 0) {
            int length = Math.min(count, 9);
            comp.append(length);
            comp.append(c);
            count -= length;
        }
        return comp;
    }

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int last = 0;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(last)) {
                add(comp, word.charAt(last), i - last);
                last = i;
            }
        }
        add(comp, word.charAt(last), word.length() - last);
        return comp.toString();
    }
}
