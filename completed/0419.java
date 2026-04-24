class Solution {

    private static final char MARKED = 'X';

    private void visitBattleship(int row, int col, char[][] board, boolean[][] isVisited) {
        isVisited[row][col] = true;

        int m = board.length;
        int n = board[0].length;

        // mark rightwards
        int dc = 1;
        while (col + dc < n && board[row][col + dc] == MARKED) {
            isVisited[row][col + dc] = true;
            dc++;
        }

        // mark downwards
        int dr = 1;
        while (row + dr < m && board[row + dr][col] == MARKED) {
            isVisited[row + dr][col] = true;
            dr++;
        }
    }

    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (isVisited[row][col]) {
                    continue;
                }

                if (board[row][col] == MARKED) {
                    visitBattleship(row, col, board, isVisited);
                    count++;
                }
                isVisited[row][col] = true;
            }
        }
        return count;
    }
}
