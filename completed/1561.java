import java.util.*;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int a = piles.length - 1;
        int b = 0;
        int m = 0;
        while (b < a) {
            b++;
            m += piles[a - 1];
            a -= 2;
        }
        return m;
    }

    public static void main(String[] args) {
        int[] piles = { 2, 4, 1, 2, 7, 8 };

        Solution solution = new Solution();
        System.out.println(solution.maxCoins(piles));
    }
}
