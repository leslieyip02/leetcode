import java.util.*;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            count1[(int) word1.charAt(i) - 97]++;
            count2[(int) word2.charAt(i) - 97]++;
        }
        Map<Integer, Integer> imbalances = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                if (count1[i] == 0 || count2[i] == 0) {
                    return false;
                }
                imbalances.put(count1[i], imbalances.getOrDefault(count1[i], 0) + 1);
                imbalances.put(count2[i], imbalances.getOrDefault(count2[i], 0) - 1);
            }
        }
        for (int count : imbalances.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
