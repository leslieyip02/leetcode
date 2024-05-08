import java.util.*;

class Solution {
    public String[] findRelativeRanks(int[] score) {
        TreeMap<Integer, Integer> indices = new TreeMap<>();
        for (int i = 0; i < score.length; i++) {
            indices.put(score[i], i);
        }

        String[] ranks = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            var greatest = indices.pollLastEntry();
            int j = greatest.getValue();
            if (i == 0) {
                ranks[j] = "Gold Medal";
            } else if (i == 1) {
                ranks[j] = "Silver Medal";
            } else if (i == 2) {
                ranks[j] = "Bronze Medal";
            } else {
                ranks[j] = (i + 1) + "";
            }
        }
        return ranks;
    }
}
