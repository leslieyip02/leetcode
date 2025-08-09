class Solution {
public:
    bool isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }

        while (n > 0) {
            if (n & 1) {
                n >>= 1;
                break;
            }
            n >>= 1;
        }
        return n == 0;
    }
};
