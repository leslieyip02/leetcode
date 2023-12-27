import java.util.*;

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int time = 0;
        int[] previous = new int[26];
        Arrays.fill(previous, -1);
        for (int i = 0; i < colors.length(); i++) {
            int color = colors.charAt(i) - 97;
            int j = previous[color];
            if (j != -1) {
                if (neededTime[i] > neededTime[j]) {
                    time += neededTime[j];
                    previous[color] = i;
                } else {
                    time += neededTime[i];
                }
            } else {
                Arrays.fill(previous, -1);
                previous[color] = i;
            }
        }
        return time;
    }
}
