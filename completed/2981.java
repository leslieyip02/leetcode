import java.util.*;

class Solution {
    public int maximumLength(String s) {
        Map<String, Integer> counts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != s.charAt(i)) {
                    break;
                }

                sb.append(s.charAt(j));
                String sub = sb.toString();
                counts.put(sub, counts.getOrDefault(sub, 0) + 1);
            }
        }

        int longest = -1;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            int count = entry.getValue();
            if (count < 3) {
                continue;
            }

            String sub = entry.getKey();
            longest = Math.max(sub.length(), longest);
        }
        return longest;
    }
}
