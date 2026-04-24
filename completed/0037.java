class Solution {
    private boolean areRowsValid(char[][] board) {
        for (int row = 0; row < 9; row++) {
            boolean[] seen = new boolean[9];
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int digit = board[row][col] - '0';
                if (seen[digit - 1]) {
                    return false;
                }
                seen[digit - 1] = true;
            }
        }
        return true;
    }

    private boolean areColumnsValid(char[][] board) {
        for (int col = 0; col < 9; col++) {
            boolean[] seen = new boolean[9];
            for (int row = 0; row < 9; row++) {
                if (board[row][col] == '.') {
                    continue;
                }

                int digit = board[row][col] - '0';
                if (seen[digit - 1]) {
                    return false;
                }
                seen[digit - 1] = true;
            }
        }
        return true;
    }

    private boolean areBoxesValid(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] seen = new boolean[9];
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        if (board[i * 3 + row][j * 3 + col] == '.') {
                            continue;
                        }

                        int digit = board[i * 3 + row][j * 3 + col] - '0';
                        if (seen[digit - 1]) {
                            return false;
                        }
                        seen[digit - 1] = true;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board) {
        // O(1) since 9 is constant
        return areRowsValid(board) && areColumnsValid(board) && areBoxesValid(board);
    }

    private boolean solveHelper(int row, int col, char[][] board) {
        // 1. Are we done?
        if (row == 9) {
            return true;
        }

        // 2. If the cell is filled, move on to the next cell
        int nextRow = col == 8 ? row + 1 : row;
        int nextCol = col == 8 ? 0 : col + 1;

        if (board[row][col] != '.') {
            return solveHelper(nextRow, nextCol, board);
        }

        // 3. Try to fill in the current cell
        for (int i = 1; i <= 9; i++) {
            // 4. Set the cell to a particular digit
            board[row][col] = (char) (i + '0');

            // 5. If its valid, keep searching
            if (isValid(board)) {
                boolean isDone = solveHelper(nextRow, nextCol, board);
                if (isDone) {
                    return true;
                }
            }

            // 6. Otherwise, try a different digit
        }

        // 7. Reset
        board[row][col] = '.';
        return false;
    }

    public void solveSudoku(char[][] board) {
        solveHelper(0, 0, board);
    }
}
