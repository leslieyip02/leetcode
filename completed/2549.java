import java.util.*;

class Solution {
    public int distinctIntegers(int n) {
        return n == 1 ? 1 : n - 1;
    }

    public static void main(String[] args) {
        int n = 5;

        Solution solution = new Solution();
        System.out.println(solution.distinctIntegers(n));
    }
}
