import java.util.*;

class Solution {
    private char find(int n, int k, boolean flip) {
        if (n == 1 || k == 0) {
            return flip ? '1' : '0';
        }

        int length = (1 << n) - 1;
        if (k == length / 2) {
            return flip ? '0' : '1';
        }

        int index = k < length / 2 ? k : length - k - 1;
        flip = k < length / 2 ? flip : !flip;
        return find(n - 1, index, flip);
    }

    public char findKthBit(int n, int k) {
        return find(n, k - 1, false);
    }
}
