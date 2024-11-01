import java.util.*;

class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));

        int consecutive = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
                if (consecutive == 2) {
                    continue;
                }

                sb.append(s.charAt(i));
                consecutive++;
            } else {
                sb.append(s.charAt(i));
                consecutive = 1;
            }
        }
        return sb.toString();
    }
}
