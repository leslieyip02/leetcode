import java.util.*:

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rows = new int[m];
        int[] cols = new int[n];

        Map<Integer, Integer[]> coordinates = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                coordinates.put(mat[i][j], new Integer[]{ i, j });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int row = coordinates.get(current)[0];
            int col = coordinates.get(current)[1];
            rows[row]++;
            cols[col]++;
            if (rows[row] == n || cols[col] == m) {
                return i;
            }
        }
        return -1;
    }
}
