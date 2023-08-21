#include <iostream>
using namespace std;

class Solution {
public:
    bool repeatedSubstringPattern(string s) {
        for (int i = 2; i <= s.length(); i++) {
            if (s.length() % i != 0) {
                continue;
            }

            int n = s.length() / i;
            string ss = s.substr(0, n);
            bool ok = true;
            for (int j = n; j < s.length(); j += n) {
                if (s.substr(j, n) != ss) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }
};

int main() {
    string s = "abab";

    Solution solution;
    cout << (solution.repeatedSubstringPattern(s) ? "true" : "false") << endl;
    cout << (solution.repeatedSubstringPattern("aba") ? "true" : "false") << endl;
    cout << (solution.repeatedSubstringPattern("aaa") ? "true" : "false") << endl;
    cout << (solution.repeatedSubstringPattern("abcabcabcabc") ? "true" : "false") << endl;
    cout << (solution.repeatedSubstringPattern("abcdefg") ? "true" : "false") << endl;
    return 0;
}