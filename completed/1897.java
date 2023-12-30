class Solution {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        int n = words.length;
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                int j = (int) word.charAt(i) - 97;
                count[j]++;
            }
        }
        for (int c : count) {
            if (c != 0 && c % n != 0) {
                return false;
            }
        }
        return true;
    }
}
