import java.util.*;

class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int left = values[0] + 0;
        int max = 0;
        for (int j = 1; j < values.length; j++) {
            max = Math.max(left + values[j] - j, max);
            if (values[j] + j > left) {
                left = values[j] + j;
            }
        }
        return max;
    }
}
