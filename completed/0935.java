import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    public int knightDialer(int n) {
        boolean[][] canMove = new boolean[10][10];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3; col++) {
                if (row == 3 && col != 1) {
                    continue;
                }

                int num = row == 3 ? 0 : row * 3 + col + 1;
                // use bits to go through all combinations
                for (int i = 0; i < 8; i++) {
                    int x = ((i & 1) == 1 ? -1 : 1);
                    int y = ((i & 2) == 2 ? -1 : 1) * 2;
                    if ((i & 4) == 4) {
                        // XOR swap
                        x ^= y;
                        y ^= x;
                        x ^= y;
                    }

                    x = col + x;
                    y = row + y;
                    if (0 <= x && x < 3 &&
                        0 <= y && y < 4 &&
                        !(y == 3 && x != 1)) {
                        int target = y == 3 ? 0 : y * 3 + x + 1;
                        canMove[num][target] = true;
                    }
                }
            }
        }

        long[] moves = new long[10];
        Arrays.fill(moves, 1);
        for (int i = 1; i < n; i++) {
            long[] tmp = new long[10];
            for (int src = 0; src < 10; src++) {
                for (int dst = 0; dst < 10; dst++) {
                    if (canMove[src][dst]) {
                        tmp[dst] += moves[src];
                        tmp[dst] %= Solution.M;
                    }
                }
            }
            moves = tmp;
        }
        return (int) Arrays.stream(moves)
            .reduce(0, (a, b) -> (a + b) % Solution.M);
    }

    public static void main(String[] args) {
        int n = 2;

        Solution solution = new Solution();
        System.out.println(solution.knightDialer(n));
    }
}
