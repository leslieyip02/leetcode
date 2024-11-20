class Solution {
    public int takeCharacters(String s, int k) {
        int[][] prefixes = new int[3][s.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < 3; j++) {
                prefixes[j][i + 1] = prefixes[j][i];
            }
            prefixes[(int) s.charAt(i) - 97][i + 1]++;
        }
        if (prefixes[0][s.length()] < k || prefixes[1][s.length()] < k || prefixes[2][s.length()] < k) {
            return -1;
        }

        int minimum = s.length();
        int left = 0;
        for (int i = 0; i <= s.length(); i++) {
            boolean ok = true;
            while (ok && left <= s.length()) {
                for (int j = 0; j < 3; j++) {
                    int needed = k - prefixes[j][i];
                    if (prefixes[j][s.length()] - prefixes[j][left] < needed) {
                        ok = false;
                        break;
                    }
                }
                if (ok) {
                    left++;
                }
            }
            minimum = Math.min(i + s.length() - left + 1, minimum);
        }
        return minimum;
    }
}
