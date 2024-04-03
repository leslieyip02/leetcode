import java.util.*;

class Solution {
    private static final int[][] DIRS = {{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};

    private boolean search(char[][] board, String word, int i0, int j0) {
        Stack<Integer[]> current = new Stack<>();
        Stack<Integer> begin = new Stack<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        current.push(new Integer[]{ i0, j0 });
        begin.push(0);
        visited[i0][j0] = true;

        while (current.size() < word.length()) {
            int i1 = current.peek()[0];
            int j1 = current.peek()[1];
            int index = begin.peek();
            char target = word.charAt(current.size());
            boolean found = false;
            for (; index < DIRS.length; index++) {
                int i2 = i1 + DIRS[index][0];
                int j2 = j1 + DIRS[index][1];
                if (i2 < 0 || i2 >= board.length || j2 < 0 || j2 >= board[0].length || visited[i2][j2]) {
                    continue;
                }

                if (board[i2][j2] == target) {
                    current.push(new Integer[]{ i2, j2 });
                    begin.pop();
                    begin.push(index + 1);
                    begin.push(0);
                    visited[i2][j2] = true;
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }

            Integer[] point = current.pop();
            begin.pop();
            visited[point[0]][point[1]] = false;
            if (current.empty()) {
                return false;
            }
        }
        return true;
    }

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (search(board, word, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
