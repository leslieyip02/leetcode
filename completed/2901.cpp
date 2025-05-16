class Solution {
private:
    bool satisfied(int i, int j, vector<string>& words, vector<int>& groups) {
        if (words[i].size() != words[j].size()) {
            return false;
        }
        if (groups[i] == groups[j]) {
            return false;
        }

        int hamming = 0;
        for (int k = 0; k < words[i].size(); k++) {
            if (words[i][k] != words[j][k]) {
                hamming++;
                if (hamming > 1) {
                    break;
                }
            }
        }
        return hamming == 1;
    }

public:
    vector<string> getWordsInLongestSubsequence(vector<string>& words, vector<int>& groups) {
        vector<vector<int>> dp(words.size());
        dp[0].push_back(0);
        for (int i = 1; i < words.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j].size() + 1 <= dp[i].size()) {
                    continue;
                }

                int previous = dp[j].back();
                if (satisfied(i, previous, words, groups)) {
                    dp[i].clear();
                    dp[i].insert(dp[i].end(), dp[j].begin(), dp[j].end());
                    dp[i].push_back(i);
                }
            }
            if (dp[i].empty()) {
                dp[i].push_back(i);
            }
        }

        int best = 0;
        for (int i = 1; i < dp.size(); i++) {
            if (dp[i].size() > dp[best].size()) {
                best = i;
            }
        }

        vector<string> result;
        for (int index : dp[best]) {
            result.push_back(words[index]);
        }
        return result;
    }
};
