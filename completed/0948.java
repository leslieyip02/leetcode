import java.util.*;

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) {
            return 0;
        }

        Arrays.sort(tokens);
        int min = 0;
        int max = tokens.length - 1;
        int score = 0;
        while (min < max) {
            if (tokens[min] > power) {
                if (score == 0) {
                    return 0;
                }

                power += tokens[max];
                score--;
                max--;
            } else {
                power -= tokens[min];
                score++;
                min++;
            }
        }
        if (power >= tokens[min]) {
            score++;
        }
        return score;
    }
}
