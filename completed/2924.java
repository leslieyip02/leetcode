import java.util.*;

class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] defeated = new boolean[n];
        for (int[] edge : edges) {
            defeated[edge[1]] = true;
        }

        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (!defeated[i]) {
                if (champion != -1) {
                    return -1;
                }
                champion = i;
            }
        }
        return champion;
    }
}
