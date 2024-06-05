import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] x = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            x[(int) words[0].charAt(i) - 97]++;
        }

        for (int i = 1; i < words.length; i++) {
            int[] y = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                y[(int) words[i].charAt(j) - 97]++;
            }

            for (int j = 0; j < 26; j++) {
                x[j] = Math.min(x[j], y[j]);
            }
        }

        List<String> common = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < x[i]; j++) {
                common.add((char) (i + 97) + "");
            }
        }
        return common;
    }
}
