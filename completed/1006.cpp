class Solution {
public:
    int clumsy(int n) {
        int result = -1;
        while (n > 0) {
            int intermediate = n;
            if (n > 1) {
                intermediate *= n - 1;
            }
            if (n > 2) {
                intermediate /= n - 2;
            }
            result = (result == -1) ? intermediate : result - intermediate;

            if (n > 3) {
                result += n - 3;
            }
            n -= 4;
        }
        return result;
    }
};
