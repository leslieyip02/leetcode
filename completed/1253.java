class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> topRow = new ArrayList<>();
        List<Integer> bottomRow = new ArrayList<>();
        for (int col = 0; col < colsum.length; col++) {
            topRow.add(0);
            bottomRow.add(0);
        }

        for (int col = 0; col < colsum.length; col++) {
            if (colsum[col] == 2) {
                topRow.set(col, 1);
                bottomRow.set(col, 1);
                upper--;
                lower--;
                if (upper < 0 || lower < 0) {
                    return matrix;
                }
            }
        }

        for (int col = 0; col < colsum.length; col++) {
            if (colsum[col] == 1) {
                if (upper > 0) {
                    topRow.set(col, 1);
                    upper--;
                } else if (lower > 0) {
                    bottomRow.set(col, 1);
                    lower--;
                } else {
                    return matrix;
                }
            }
        }

        if (upper == 0 && lower == 0) {
            matrix.add(topRow);
            matrix.add(bottomRow);
        }
        return matrix;
    }
}
