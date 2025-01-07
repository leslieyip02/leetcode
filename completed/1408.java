import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> substrings = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (int i = 0; i < words.length; i++) {
            for (int j = words.length - 1; j > i; j--) {
                if (words[j].contains(words[i])) {
                    substrings.add(words[i]);
                    break;
                }

                if (words[j].length() == words[i].length()) {
                    break;
                }
            }
        }
        return substrings;
    }
}
