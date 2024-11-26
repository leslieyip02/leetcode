import java.util.*;
import java.util.stream.*;

class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (Arrays.stream(grid[i]).sum() == n - 1) {
                return i;
            }
        }
        return -1;
    }
}
