import java.util.*;

class Solution {
    private int print(List<Character> letters, int start, int end, int[][] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int moves = 1 + print(letters, start + 1, end, memo);
        for (int i = start + 1; i <= end; i++) {
            if (letters.get(i) == letters.get(start)) {
                moves = Math.min(print(letters, start, i - 1, memo) + print(letters, i + 1, end, memo), moves);
            }
        }
        memo[start][end] = moves;
        return moves;
    }

    public int strangePrinter(String s) {
        List<Character> letters = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (!letters.isEmpty() && letters.get(letters.size() - 1) == s.charAt(i)) {
                continue;
            }
            letters.add(s.charAt(i));
        }
        int n = letters.size();
        return print(letters, 0, n - 1, new int[n][n]);
    }
}
