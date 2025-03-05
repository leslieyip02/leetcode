class Solution {
    private boolean ok(String word, int skip) {
        int[] f = new int[26];
        for (int i = 0; i < word.length(); i++) {
            if (i == skip) {
                continue;
            }
            f[(int) word.charAt(i) - 97]++;
        }

        int c = -1;
        for (int i = 0; i < 26; i++) {
            if (f[i] == 0) {
                continue;
            }
            if (c == -1) {
                c = f[i];
            } else if (f[i] != c) {
                return false;
            }
        }
        return true;
    }

    public boolean equalFrequency(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (ok(word, i)) {
                return true;
            }
        }
        return false;
    }
}
