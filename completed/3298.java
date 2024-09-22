class Solution {
    private boolean isValid(int[] counts, int[] target) {
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] < target[i]) {
                return false;
            }
        }
        return true;
    }

    public long validSubstringCount(String word1, String word2) {
        if (word2.length() > word1.length()) {
            return 0;
        }

        int[] target = new int[26];
        for (int i = 0; i < word2.length(); i++) {
            target[(int) word2.charAt(i) - 97]++;
        }

        int[] counts = new int[26];
        int left = 0;
        int right = 0;
        long total = 0;
        while (right < word1.length()) {
            while (isValid(counts, target)) {
                total += 1 + word1.length() - right;
                counts[(int) word1.charAt(left) - 97]--;
                left++;
            }
            counts[(int) word1.charAt(right) - 97]++;
            right++;
        }
        while (isValid(counts, target)) {
            total++;
            counts[(int) word1.charAt(left) - 97]--;
            left++;
        }
        return total;
    }
}
