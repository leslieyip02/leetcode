class Solution {

    private static final int NOT_FOUND = -1;

    private boolean isMatch(String word, int[][] nextIndices) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            int nextIndex = nextIndices[(int) word.charAt(i) - 'a'][index];
            if (nextIndex == NOT_FOUND) {
                return false;
            }
            index = nextIndex + 1;
        }
        return true;
    }

    public int numMatchingSubseq(String s, String[] words) {
        // don't feel like writing a trie
        int[][] nextIndices = new int[26][s.length() + 1];
        for (int j = 0; j < 26; j++) {
            nextIndices[j][s.length()] = NOT_FOUND;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                nextIndices[j][i] = nextIndices[j][i + 1];
            }
            nextIndices[(int) s.charAt(i) - 'a'][i] = i;
        }

        int num = 0;
        for (String word : words) {
            if (isMatch(word, nextIndices)) {
                num++;
            }
        }
        return num;
    }
}
