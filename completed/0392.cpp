#include <iostream>
using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == s.length(); 
    }
};

int main() {
    string s = "abc";
    string t = "ahbgdc";

    Solution solution;
    cout << (solution.isSubsequence(s, t) ? "true" : "false") << endl;
    cout << (solution.isSubsequence("axs", t) ? "true" : "false") << endl;
    return 0;
}
