import java.util.*;

class Solution {
    public int[] singleNumber(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total ^= num;
        }

        int mask = 1;
        while ((total & mask) == 0) {
            mask <<= 1;
        }

        int[] result = new int[2];
        for (int num : nums) {
            // split into those with ith bit on/off
            // the other duplicate terms will cancel out
            if ((num & mask) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
}
