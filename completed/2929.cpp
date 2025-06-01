class Solution {
private:
    long long split(int n, int limit) {
        if (n > 2 * limit) {
            return 0;
        }

        int start = n - min(limit, n);
        int end = min(limit, n);
        return end - start + 1;
    }

public:
    long long distributeCandies(int n, int limit) {
        long long ways = 0;
        for (int i = 0; i <= min(n, limit); i++) {
            ways += split(n - i, limit);
        }
        return ways;
    }
};
