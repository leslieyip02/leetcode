import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};

    private Set<Integer> visited;

    private int encode(Integer[][] board) {
        int encoded = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                encoded |= board[i][j] << ((i * board[0].length + j) * 3);
            }
        }
        return encoded;
    }

    private boolean isSolved(Integer[][] board) {
        return board[0][0] == 1 && board[0][1] == 2 && board[0][2] == 3
            && board[1][0] == 4 && board[1][1] == 5;
    }

    private List<Integer[][]> makeMoves(Integer[][] board, int row, int col) {
        List<Integer[][]> states = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newRow >= board.length || newCol < 0 || newCol >= board[0].length) {
                continue;
            }

            Integer[][] state = new Integer[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                state[i] = board[i].clone();
            }
            state[row][col] = board[newRow][newCol];
            state[newRow][newCol] = board[row][col];
            int encoded = encode(state);
            if (!visited.contains(encoded)) {
                states.add(state);
            }
            visited.add(encoded);
        }
        return states;
    }

    public int slidingPuzzle(int[][] board) {
        Queue<Integer[][]> states = new LinkedList<>();
        Integer[][] state = new Integer[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                state[i][j] = board[i][j];
            }
        }
        states.add(state);

        Queue<Integer> leastMoves = new LinkedList<>();
        leastMoves.add(0);

        visited = new HashSet<>();
        visited.add(encode(state));

        while (!states.isEmpty()) {
            state = states.poll();
            int least = leastMoves.poll();
            if (isSolved(state)) {
                return least;
            }

            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[0].length; j++) {
                    if (state[i][j] != 0) {
                        continue;
                    }

                    List<Integer[][]> moved = makeMoves(state, i, j);
                    states.addAll(moved);
                    for (int k = 0; k < moved.size(); k++) {
                        leastMoves.add(least + 1);
                    }
                }
            }
        }
        return -1;
    }
}
