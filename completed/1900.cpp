class Solution {
public:
    vector<int> earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        if (firstPlayer + secondPlayer == n + 1) {
            return { 1, 1 };
        }
        if (n == 3 || n == 4) {
            return { 2, 2 };
        }

        int left = min(firstPlayer, secondPlayer);
        int right = max(firstPlayer, secondPlayer);
        if (left - 1 > n - right) {
            int tmp = n + 1 - left;
            left = n + 1 - right;
            right = tmp;
        }

        bool sameSide = right * 2 <= n + 1;
        int between = sameSide ? right - left : (n + 1 - right) - left;
        int gap = sameSide ? 0 : (right - (n + 1 - right)) / 2;

        int m = (n + 1) / 2;
        int earliest = n;
        int latest = 1;
        for (int i = 1; i <= left; i++) {
            for (int j = 1; j <= between; j++) {
                vector<int> next = earliestAndLatest(m, i, i + j + gap);
                earliest = min(next[0] + 1, earliest);
                latest = max(next[1] + 1, latest);
            }
        }
        return { earliest, latest };
    }
};
