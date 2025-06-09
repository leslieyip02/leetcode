class Solution {
private:
    int inBetween(long current, long next, long n) {
        int count = 0;
        while (current <= n) {
            count += min(n + 1, next) - current;
            current *= 10;
            next *= 10;
        }
        return count;
    }

public:
    int findKthNumber(int n, int k) {
        int current = 1;
        k--;
        while (k > 0) {
            int count = inBetween(current, current + 1, n);
            if (count <= k) {
                k -= count;
                current++;
            } else {
                k--;
                current *= 10;
            }
        }
        return current;
    }
};
