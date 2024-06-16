import java.util.*;

class Solution {
    public int minPatches(int[] nums, int n) {
        // maximum that can be formed with current range
        long maximum = 1;
        int patches = 0;
        int i = 0;
        while (maximum <= n) {
            if (i < nums.length && nums[i] <= maximum) {
                maximum += nums[i];
                i++;
            } else {
                maximum *= 2;
                patches++;
            }
        }
        return patches;
    }
}
