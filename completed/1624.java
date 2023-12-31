class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n = s.length();
        int m = -1;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    m = Math.max(j - i - 1, m);
                }
            }
        }
        return m;
    }
}
