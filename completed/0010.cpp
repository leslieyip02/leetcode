#include <iostream>
using namespace std;

class Solution {
public:
    bool isMatch(string s, string p) {
        return recursiveMatch(s, 0, p, 0);
    }

    bool recursiveMatch(string& s, int i, string& p, int j) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        bool currentMatch = i < s.length() && (s[i] == p[j] || p[j] == '.');
        if (j + 1 < p.length() && p[j + 1] == '*') {
            // match current char
            if (currentMatch && recursiveMatch(s, i + 1, p, j)) {
                return true;
            }

            // match 0 chars
            if (recursiveMatch(s, i, p, j + 2)) {
                return true;
            }
        } else if (currentMatch && recursiveMatch(s, i + 1, p, j + 1)) {
            return true;
        }

        return false;
    }
};

int main() {
    string s = "aa";
    string p = "a";

    Solution solution;
    cout << solution.isMatch(s, p) << endl; // 0
    cout << solution.isMatch("aaaaaaa", "a*........") << endl; // 0
    cout << solution.isMatch("aaa", "aaaa") << endl; // 0
    cout << solution.isMatch(s, "a*") << endl; // 1
    cout << solution.isMatch("ab", "a.") << endl; // 1
    cout << solution.isMatch("ab", ".*") << endl; // 1
    cout << solution.isMatch("aba", "a.a") << endl; // 1
    cout << solution.isMatch("abcdefg", "a.cdefg") << endl; // 1
    cout << solution.isMatch("aaaaaaa", "a......") << endl; // 1
    cout << solution.isMatch("abcd", "abcd***") << endl; // 1
    cout << solution.isMatch("abcdddde", "abcd*e") << endl; // 1
    cout << solution.isMatch("aaaaaaa", "a*aaaaa") << endl; // 1
    cout << solution.isMatch("aaaaaaa", "a*......") << endl; // 1
    cout << solution.isMatch("aab", "c*a*b") << endl; // 1
    cout << solution.isMatch("a", "ab*") << endl; // 1
    cout << solution.isMatch("aaaaaaa", "a*.......") << endl; // 1
    cout << solution.isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*") << endl; // 1
    cout << solution.isMatch("cbbaaccccbabcaa", ".*a*aa*.*b*.c*.*a*") << endl; // 1
    return 0;
}
