import java.util.*;

class Solution {
    private boolean isVowel(char letter) {
        switch (letter) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;

            default:
                return false;
        }
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSums = new int[words.length + 1];
        for (int i = 0; i < words.length; i++) {
            prefixSums[i + 1] = prefixSums[i];

            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                prefixSums[i + 1]++;
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            ans[i] = prefixSums[r + 1] - prefixSums[l];
        }
        return ans;
    }
}
