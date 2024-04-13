import java.util.*;

class Solution {
    public int jump(int[] nums) {
        int[] moves = new int[nums.length];
        Arrays.fill(moves, (int) 1e6);
        moves[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j <= nums[i] && i + j < moves.length; j++) {
                moves[i + j] = Math.min(moves[i] + 1, moves[i + j]);
            }
        }
        return moves[moves.length - 1];
    }
}
