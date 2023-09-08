#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int minExtraChar(string s, vector<string>& dictionary) {
        vector<int> dp(s.length(), 0);
        unordered_set<string> d;
        for (auto word : dictionary) {
            d.insert(word);
        }

        for (int i = 0; i < s.length(); i++) {
            dp[i] = (i > 0 ? dp[i - 1] : 0) + 1;
            for (int j = 0; j <= i; j++) {
                if (d.find(s.substr(j, i - j + 1)) != d.end()) {
                    dp[i] = min((j > 0 ? dp[j - 1] : 0), dp[i]);
                }
            }
        }
        return dp.back();
    }
};

int main() {
    string s = "leetscode";
    vector<string> dictionary = { "leet", "code", "leetcode" };

    Solution solution;
    // cout << solution.minExtraChar(s, dictionary) << endl;
    // dictionary = { "hello", "world" };
    // cout << solution.minExtraChar("sayhelloworld", dictionary) << endl;
    // dictionary = { "leet", "code", "leetcode" };
    // cout << solution.minExtraChar("leetcode", dictionary) << endl;
    // dictionary = { "leet", "leetcode" };
    // cout << solution.minExtraChar("abcleetcleetcode", dictionary) << endl;
    // dictionary = { "leet", "leetcode" };
    dictionary = { "ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu" };
    cout << solution.minExtraChar("dwmodizxvvbosxxw", dictionary) << endl;
    return 0;
}