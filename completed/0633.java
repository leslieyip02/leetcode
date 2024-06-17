import java.util.*;

class Solution {
    public boolean judgeSquareSum(int c) {
        Set<Integer> squares = new HashSet<>();
        long current = 0;
        while (current * current <= c) {
            squares.add((int) (current * current));
            current++;
        }

        for (int aa : squares) {
            int bb = c - aa;
            if (squares.contains(bb)) {
                return true;
            }
        }
        return false;
    }
}
