class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isAllowed = new boolean[26];
        for (int i = 0; i < allowed.length(); i++) {
            isAllowed[(int) allowed.charAt(i) - 'a'] = true;
        }

        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (!isAllowed[(int) word.charAt(i) - 97]) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }
}
