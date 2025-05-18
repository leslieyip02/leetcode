class Solution {
private:
    static constexpr int M = (int) 1e9 + 7;

    bool isValidColumn(int mask, int m) {
        int previous = -1;
        for (int i = 0; i < m; i++) {
            int current = mask % 3;
            if (current == previous) {
                return false;
            }
            previous = current;
            mask /= 3;
        }
        return true;
    }

    bool isValidColumnPair(int mask1, int mask2, int m) {
        for (int i = 0; i < m; i++) {
            if ((mask1 % 3) == (mask2 % 3)) {
                return false;
            }
            mask1 /= 3;
            mask2 /= 3;
        }
        return true;
    }

    int dfs(int mask, unordered_map<int, vector<int>>& adjacents, int n, vector<unordered_map<int, int>>& memo) {
        if (n == 1) {
            return 1;
        }

        if (memo[n].find(mask) != memo[n].end()) {
            return memo[n][mask];
        }

        int result = 0;
        for (int adjacent : adjacents[mask]) {
            result += dfs(adjacent, adjacents, n - 1, memo);
            result %= M;
        }
        memo[n][mask] = result;
        return result;
    }

public:
    int colorTheGrid(int m, int n) {
        vector<int> masks;
        int maxMask = pow(3, m);
        for (int mask = 0; mask < maxMask; mask++) {
            if (!isValidColumn(mask, m)) {
                continue;
            }
            masks.push_back(mask);
        }

        unordered_map<int, vector<int>> adjacents;
        for (int mask1 : masks) {
            for (int mask2 : masks) {
                if (!isValidColumnPair(mask1, mask2, m)) {
                    continue;
                }
                adjacents[mask1].push_back(mask2);
            }
        }

        vector<unordered_map<int, int>> memo(n + 1);
        int result = 0;
        for (int mask : masks) {
            result += dfs(mask, adjacents, n, memo);
            result %= M;
        }
        return result;
    }
};
