import java.util.*;

class Solution {
    public int minOperations(String[] logs) {
        int moves = 0;
        for (String log : logs) {
            if (log.compareTo("../") == 0) {
                moves = Math.max(moves - 1, 0);
            } else if (log.compareTo("./") != 0) {
                moves++;
            }
        }
        return moves;
    }
}
