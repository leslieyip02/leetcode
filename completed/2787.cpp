class Solution {
private:
    const int M = 1e9 + 7;

public:
    int numberOfWays(int n, int x) {
        vector<int> powers = { 0 };
        vector<vector<long>> dp(n + 1, vector<long>(n + 1));
        for (int base = 1; base <= n; base++) {
            int power = pow(base, x);
            if (power > n) {
                break;
            }
            powers.push_back(power);
            dp[power][base] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!dp[i][j]) {
                    continue;
                }

                for (int k = j + 1; k <= n; k++) {
                    if (k >= powers.size()) {
                        break;
                    }

                    int next = i + powers[k];
                    if (next > n) {
                        break;
                    }

                    dp[next][k] += dp[i][j];
                    dp[next][j] %= M;
                }
            }
        }

        long ways = 0;
        for (int i = 1; i <= n; i++) {
            ways += dp[n][i];
            ways %= M;
        }
        return (int) ways;
    }
};
