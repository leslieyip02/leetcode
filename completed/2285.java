import java.util.*;

class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long[] indegrees = new long[n];
        for (int[] road : roads) {
            for (int city : road) {
                indegrees[city]++;
            }
        }

        long sum = 0;
        Arrays.sort(indegrees);
        for (int i = 0; i < n; i++) {
            sum += indegrees[i] * (i + 1);
        }
        return sum;
    }
}
