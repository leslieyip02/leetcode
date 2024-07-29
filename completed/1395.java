import java.util.*;

class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;

        int[][] ascending = new int[3][n];
        int[][] descending = new int[3][n];
        Arrays.fill(ascending[0], 1);
        Arrays.fill(descending[0], 1);

        for (int index = 1; index < 3; index++) {
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (rating[i] < rating[j]) {
                        ascending[index][j] += ascending[index - 1][i];
                    }
                    if (rating[i] > rating[j]) {
                        descending[index][j] += descending[index - 1][i];
                    }
                }
            }
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += ascending[2][i] + descending[2][i];
        }
        return total;
    }
}
