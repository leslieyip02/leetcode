class Solution {
    public int numberOfSubstrings(String s) {
        char[] letters = new char[] { 'a', 'b', 'c' };
        int[][] nextIndices = new int[3][s.length()];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(nextIndices[i], -1);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i < s.length() - 1) {
                for (int j = 0; j < 3; j++) {
                    nextIndices[j][i] = nextIndices[j][i + 1];
                }
            }
            for (int j = 0; j  < 3; j++) {
                if (s.charAt(i) == letters[j]) {
                    nextIndices[j][i] = i;
                    break;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean ok = true;
            int furthest = i;
            for (int j = 0; j  < 3; j++) {
                if (s.charAt(i) == letters[j]) {
                    continue;
                }
                if (nextIndices[j][i] == -1) {
                    ok = false;
                }
                furthest = Math.max(nextIndices[j][i], furthest);
            }
            if (!ok) {
                break;
            }
            count += s.length() - furthest;
        }
        return count;
    }
}
