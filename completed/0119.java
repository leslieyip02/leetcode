import java.util.*;

class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row0 = new Integer[rowIndex + 1];
        Integer[] row1 = new Integer[rowIndex + 1];
        row0[0] = 1;
        for (int i = 0; i <= rowIndex; i++) {
            if (i % 2 == 0) {
                row1[0] = 1;
                for (int j = 1; j < i; j++) {
                    row1[j] = row0[j - 1] + row0[j];
                }
                row1[i] = 1;
            } else {
                row0[0] = 1;
                for (int j = 1; j < i; j++) {
                    row0[j] = row1[j - 1] + row1[j];
                }
                row0[i] = 1;
            }
        }
        return Arrays.asList(rowIndex % 2 == 0 ? row1 : row0);
    }

    public static void main(String[] args) {
        int rowIndex = 4;

        Solution solution = new Solution();
        var result = solution.getRow(rowIndex);
        for (var v : result) {
            System.out.print(v + " ");
        }
        System.out.println();
    }
}
