import java.util.*;

class Solution {
    private Map<Integer, String> memo;

    private List<String> choose(String s, int start, int end, Set<String> words) {
        List<String> sentences = new ArrayList<>();
        String word = s.substring(start, end);
        if (end == s.length()) {
            if (words.contains(word)) {
                sentences.add(word);
            } 
            return sentences;
        }

        List<String> options;
        if (words.contains(word)) {
            // choose
            options = choose(s, end, end + 1, words);
            for (String option : options) {
                sentences.add(word + " " + option);
            }
        }

        // don't choose
        options = choose(s, start, end + 1, words);
        sentences.addAll(options);
        return sentences;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for (String word : wordDict) {
            words.add(word);
        }
        return choose(s, 0, 1, words);
    }
}
