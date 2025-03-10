class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private boolean ok(Map<Character, Integer> vowelCounts, int consonantCount, int k) {
        return vowelCounts.getOrDefault('a', 0) > 0 &&
            vowelCounts.getOrDefault('e', 0) > 0 &&
            vowelCounts.getOrDefault('i', 0) > 0 &&
            vowelCounts.getOrDefault('o', 0) > 0 &&
            vowelCounts.getOrDefault('u', 0) > 0 &&
            consonantCount == k;
    }

    public long countOfSubstrings(String word, int k) {
        int[] nextConsonantIndices = new int[word.length()];
        int nextConsonantIndex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonantIndices[i] = nextConsonantIndex;
            if (!isVowel(word.charAt(i))) {
                nextConsonantIndex = i;
            }
        }

        Map<Character, Integer> vowelCounts = new HashMap<>();
        int consonantCount = 0;

        int left = 0;
        int right = 0;
        long count = 0;
        while (right < word.length()) {
            char current = word.charAt(right);
            if (isVowel(current)) {
                vowelCounts.put(current, vowelCounts.getOrDefault(current, 0) + 1);
            } else {
                consonantCount++;
            }

            while (consonantCount > k) {
                char previous = word.charAt(left);
                if (isVowel(previous)) {
                    vowelCounts.put(previous, vowelCounts.get(previous) - 1);
                } else {
                    consonantCount--;
                }
                left++;
            }

            while (left < word.length() && ok(vowelCounts, consonantCount, k)) {
                count += nextConsonantIndices[right] - right;
                char previous = word.charAt(left);
                if (isVowel(previous)) {
                    vowelCounts.put(previous, vowelCounts.get(previous) - 1);
                } else {
                    consonantCount--;
                }
                left++;
            }
            right++;
        }
        return count;
    }
}
