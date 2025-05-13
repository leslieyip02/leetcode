class Solution {
private:
    int M = (int) 1e9 + 7;

    int transform(vector<vector<int>> &dp, int c, int t) {
        if (dp[c][t] != 0) {
            return dp[c][t];
        }

        dp[c][t] = c == 25 ? transform(dp, 0, t - 1) + transform(dp, 1, t - 1) : transform(dp, c + 1, t - 1);
        dp[c][t] %= M;
        return dp[c][t];
    }

public:
    int lengthAfterTransformations(string s, int t) {
        vector<vector<int>> dp(26, vector<int>(t + 1, 0));
        for (int i = 0; i < 26; i++) {
            dp[i][0] = 1;
        }

        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            length += transform(dp, (int) s[i] - 'a', t);
            length %= M;
        }
        return length;
    }
};
