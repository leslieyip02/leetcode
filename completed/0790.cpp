class Solution {
private:
    int M = (int) 1e9 + 7;

public:
    int numTilings(int n) {
        vector<int> dp(max(n, 3));
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 5;
        if (n <= 3) {
            return dp[n - 1];
        }

        for (int i = 3; i < n; i++) {
            dp[i] = 2 * dp[i - 1] % M + dp[i - 3];
            dp[i] %= M;
        }
        return dp.back();
    }
};
