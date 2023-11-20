import java.util.*;
import java.util.stream.*;

class Solution {
    private static char[] garbageTypes = { 'M', 'P', 'G' };

    private int count(String s, char ch) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                c++;
            }
        }
        return c;
    }

    public int garbageCollection(String[] garbage, int[] travel) {
        int[] counts = new int[3];
        int[] lastIndex = new int[3];
        int[] prefixSum = new int[garbage.length];
        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < 3; j++) {
                int c = count(garbage[i], Solution.garbageTypes[j]);
                if (c > 0) {
                    lastIndex[j] = i;
                }
                counts[j] += c;
            }
            if (i > 0) {
                prefixSum[i] = prefixSum[i - 1] + travel[i - 1];
            }
        }
        int totalCollection = Arrays.stream(counts)
            .reduce(0, (subtotal, count) -> subtotal + count);
        int totalTravel = Arrays.stream(lastIndex)
            .reduce(0, (subtotal, index) -> subtotal + prefixSum[index]);
        return totalCollection + totalTravel;
    }

    public static void main(String[] args) {
        String[] garbage = { "G", "P", "GP", "GG" };
        int[] travel = { 2, 4, 3 };

        Solution solution = new Solution();
        System.out.println(solution.garbageCollection(garbage, travel));
    }
}
