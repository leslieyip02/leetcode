import java.util.*;

class Solution {
    private boolean enough(int current, int[][] required, int[] bank) {
        for (int i = 0; i < required[current].length; i++) {
            if (required[current][i] > bank[i]) {
                return false;
            }
        }
        return true;
    }

    private int choose(int current, String[] words, int[][] required, int[] bank, int[] scores) {
        int score = 0;
        if (current == words.length) {
            return score;
        }

        // choose
        if (enough(current, required, bank)) {
            for (int i = 0; i < required[current].length; i++) {
                bank[i] -= required[current][i];
            }
            score = scores[current] + choose(current + 1, words, required, bank, scores);
            for (int i = 0; i < required[current].length; i++) {
                bank[i] += required[current][i];
            }
        }

        // don't choose
        score = Math.max(choose(current + 1, words, required, bank, scores), score);
        return score;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[][] required = new int[words.length][26];
        int[] scores = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int k = (int) words[i].charAt(j) - 97;
                required[i][k]++;
                scores[i] += score[k];
            }
        }

        int[] bank = new int[26];
        for (char letter : letters) {
            int k = (int) letter - 97;
            bank[k]++;
        }

        return choose(0, words, required, bank, scores);
    }
}
