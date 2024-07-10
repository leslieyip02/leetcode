import java.util.*;

class Solution {
    private final static int POSITIVE = 0;
    private final static int NEGATIVE = 1;

    public int getMaxLen(int[] nums) {
        int[][] lengths = new int[2][nums.length];
        if (nums[0] > 0) {
            lengths[POSITIVE][0] = 1;
        } else if (nums[0] < 0) {
            lengths[NEGATIVE][0] = 1;
        }

        int maximum = lengths[POSITIVE][0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                lengths[POSITIVE][i] = lengths[POSITIVE][i - 1] + 1;
                if (lengths[NEGATIVE][i - 1] > 0) {
                    lengths[NEGATIVE][i] = lengths[NEGATIVE][i - 1] + 1;
                }
            } else if (nums[i] < 0) {
                lengths[NEGATIVE][i] = lengths[POSITIVE][i - 1] + 1;
                if (lengths[NEGATIVE][i - 1] > 0) {
                    lengths[POSITIVE][i] = lengths[NEGATIVE][i - 1] + 1;
                }
            }
            maximum = Math.max(lengths[POSITIVE][i], maximum);
        }
        return maximum;
    }
}
