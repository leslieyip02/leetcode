#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
    vector<int> longestPalindrome(string s) {
        vector<int> centre(s.length());
        vector<int> length(s.length(), 1); 
        int l = 0;
        int r = -1;
        for (int i = 0; i < s.length(); i++) {
            int j = i > r ? 1 : min(centre[l + r - i], r - i + 1);
            while (j <= i && i + j < s.length() && s[i - j] == s[i + j]) {
                length[i + j] = 2 * j + 1;
                j++;
            }
            centre[i] = j--;
            if (i + centre[i] > r) {
                l = i - j;
                r = i + j;
            }
        }

        for (int i = 1; i < length.size(); i++) {
            length[i] = max(length[i - 1], length[i]);
        }
        return length;
    }

public:
    long long maxProduct(string s) {
        vector<int> prefix = longestPalindrome(s);
        vector<int> suffix = longestPalindrome(string(s.rbegin(), s.rend()));

        long long m = 0;
        int i = 0;
        int j = suffix.size() - 2;
        while (i < s.length() - 1) {
            m = max((long long) prefix[i] * suffix[j], m);
            i++;
            j--;
        }
        return m;
    }
};

int main() {
    string s = "ababbb";

    Solution solution;
    cout << solution.maxProduct(s) << endl;
    // cout << solution.maxProduct("zaaaxbbby") << endl;
    // cout << solution.maxProduct("ggbswiymmlevedhkbdhntnhdbkhdevelmmyiwsbgg") << endl;
    return 0;
}
