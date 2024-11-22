import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Map<BitSet, Integer> counts = new HashMap<>();
        for (int i = 0; i < m; i++) {
            BitSet row = new BitSet(n);
            for (int j = 0; j < n; j++) {
                row.set(j, matrix[i][j] == 1);
            }

            if (counts.containsKey(row)) {
                counts.put(row, counts.get(row) + 1);
                continue;
            }

            row.flip(0, n);
            counts.put(row, counts.getOrDefault(row, 0) + 1);
        }

        int maximum = 1;
        for (int count : counts.values()) {
            maximum = Math.max(count, maximum);
        }
        return maximum;
    }
}
