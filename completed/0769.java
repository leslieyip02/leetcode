import java.util.*;

class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        boolean[] filled = new boolean[n];
        int last = 0;
        int chunks = 0;
        for (int i = 0; i < n; i++) {
            filled[arr[i]] = true;

            boolean sortable = true;
            for (int j = last; j <= i; j++) {
                if (!filled[j]) {
                    sortable = false;
                    break;
                }
            }

            if (sortable) {
                last = i + 1;
                chunks++;
            }
        }

        return chunks;
    }
}
