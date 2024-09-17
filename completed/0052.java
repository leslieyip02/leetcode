import java.util.*;

class Solution {
    private List<List<String>> results;
    private List<String> board;

    private void place(
        int n,
        int row,
        Set<Integer> columns,
        Set<Integer> positiveDiagonals,
        Set<Integer> negativeDiagonals
    ) {
        if (row == n) {
            List<String> copy = new ArrayList<>();
            copy.addAll(board);
            results.add(copy);
            return;
        }

        for (int column = 0; column < n; column++) {
            if (columns.contains(column) ||
                positiveDiagonals.contains(row + column) ||
                negativeDiagonals.contains(row - column)) {
                continue;
            }

            columns.add(column);
            positiveDiagonals.add(row + column);
            negativeDiagonals.add(row - column);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < column; i++) {
                sb.append('.');
            }
            sb.append('Q');
            for (int i = column + 1; i < n; i++) {
                sb.append('.');
            }
            board.add(sb.toString());

            place(n, row + 1, columns, positiveDiagonals, negativeDiagonals);

            columns.remove(column);
            positiveDiagonals.remove(row + column);
            negativeDiagonals.remove(row - column);
            board.remove(board.size() - 1);
        }
    }

    public int totalNQueens(int n) {
        results = new ArrayList<>();
        board = new ArrayList<>();

        Set<Integer> columns = new HashSet<>();
        Set<Integer> positiveDiagonals = new HashSet<>();
        Set<Integer> negativeDiagonals = new HashSet<>();

        place(n, 0, columns, positiveDiagonals, negativeDiagonals);
        return results.size();
    }
}
