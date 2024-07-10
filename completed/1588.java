import java.util.*;

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] subsetSums = new int[arr.length];
        subsetSums[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            subsetSums[i] = subsetSums[i - 1] + arr[i];
        }

        int total = 0;
        for (int length = 1; length <= arr.length; length += 2) {
            total += subsetSums[length - 1];
            for (int i = length; i < arr.length; i++) {
                total += subsetSums[i] - subsetSums[i - length];
            }
        }
        return total;
    }
}
