#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        if (s1.length() == 0 || s2.length() == 0) {
            return s1 + s2 == s3;
        }

        vector<vector<bool>> dp(s1.length() + 1, vector<bool>(s2.length() + 1));
        dp[0][0] = true;
        for (int i1 = 1; i1 <= s1.length(); i1++) {
            if (s1[i1 - 1] != s3[i1 - 1]) {
                break;
            }
            dp[i1][0] = true;
        }
        for (int i2 = 1; i2 <= s1.length(); i2++) {
            if (s2[i2 - 1] != s3[i2 - 1]) {
                break;
            }
            dp[0][i2]= true;
        }

        for (int i1 = 1; i1 <= s1.length(); i1++) {
            for (int i2 = 1; i2 <= s2.length(); i2++) {
                if (dp[i1][i2 - 1]) {
                    dp[i1][i2] = s2[i2 - 1] == s3[i1 + i2 - 1];
                } else if (dp[i1 - 1][i2]) {
                    dp[i1][i2] = s1[i1 - 1] == s3[i1 + i2 - 1];
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
};

int main() {
    string s1 = "aabcc";
    string s2 = "dbbca";
    string s3 = "aadbbcbcac";

    Solution solution;
    cout << (solution.isInterleave(s1, s2, s3) ? "true" : "false") << endl;
    cout << (solution.isInterleave(s1, s2, "aadbbbaccc") ? "true" : "false") << endl;
    cout << (solution.isInterleave("", "", "") ? "true" : "false") << endl;
    cout << (solution.isInterleave("", "", "a") ? "true" : "false") << endl;
    cout << (solution.isInterleave("", "b", "b") ? "true" : "false") << endl;
    return 0;
}