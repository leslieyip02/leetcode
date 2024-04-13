import java.util.*;

class Solution {
    private boolean isGoodLine(List<Character> cells) {
        if (cells.size() < 3 || cells.get(0) != cells.get(cells.size() - 1)) {
            return false;
        }

        for (int i = 1; i < cells.size() - 1; i++) {
            if (cells.get(i) == cells.get(0)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        int[][] offsets = {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 },
            { 1, 1 },
            { 1, -1 },
            { -1, 1 },
            { -1, -1 },
        };

        for (var offset : offsets) {
            List<Character> cells = new ArrayList<>();
            cells.add(color);

            int i = rMove + offset[0];
            int j = cMove + offset[1];
            while (i >= 0 && i < board.length && j >= 0 && j < board[i].length) {
                if (board[i][j] == '.') {
                    break;
                }

                cells.add(board[i][j]);
                if (isGoodLine(cells)) {
                    return true;
                }
                i += offset[0];
                j += offset[1];
            }
        }

        return false;
    }
}
