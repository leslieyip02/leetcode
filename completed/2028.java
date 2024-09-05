import java.util.*;

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int target = mean * (n + m);
        for (int roll : rolls) {
            target -= roll;
        }

        for (int i = 1; i < 6; i++) {
            int remainder = target - n * i;
            if (remainder < 0) {
                break;
            }
            if (remainder > n) {
                continue;
            }

            int[] possible = new int[n];
            Arrays.fill(possible, i);
            for (int j = 0; j < remainder; j++) {
                possible[j]++;
            }
            return possible;
        }
        return new int[0];
    }
}
