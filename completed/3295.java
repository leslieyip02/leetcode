import java.util.*;

class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>();
        for (String word : bannedWords) {
            set.add(word);
        }

        int matched = 0;
        for (String word : message) {
            if (set.contains(word)) {
                matched++;
                if (matched >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
