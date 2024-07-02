import java.util.*; 

class Solution {
    private static final int M = 1337;

    // for 0 <= b <= 10
    private int mod(int a, int b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a % M;
        }

        int left = b / 2;
        int right = b - left;
        return (mod(a, left) * mod(a, right)) % M;
    }
 
    private int helper(int a, Stack<Integer> left) {
        if (left.empty()) {
            return 1;
        }
        int right = left.pop();
        return (mod(helper(a, left), 10) * mod(a, right)) % M;
    }

    public int superPow(int a, int[] b) {
        Stack<Integer> left = new Stack<>();
        for (int digit : b) {
            left.push(digit);
        }
        return helper(a, left);
    }
}
