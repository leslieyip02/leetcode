import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int[] lefts = new int[26];
        Arrays.fill(lefts, -1);
        int[] rights = new int[26];
        Arrays.fill(rights, -1);
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i) - 97;
            if (lefts[index] == -1) {
                lefts[index] = i;
            }
            rights[index] = i;
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (lefts[i] == -1) {
                continue;
            }

            Set<Character> unique = new HashSet<>();
            for (int j = lefts[i] + 1; j < rights[i]; j++) {
                unique.add(s.charAt(j));
            }
            count += unique.size();
        }
        return count;
    }
}
