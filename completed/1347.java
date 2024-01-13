class Solution {
    public int minSteps(String s, String t) {
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int j = (int) s.charAt(i) - 97;
            counts[j]++;
        }
        for (int i = 0; i < t.length(); i++) {
            int j = (int) t.charAt(i) - 97;
            counts[j]--;
        }
        int steps = 0;
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                steps += counts[i];
            }
        }
        return steps;
    }
}
