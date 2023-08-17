#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestPalindrome(string s) {
        int n = s.length();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            // check odd
            int j = 0;
            while (i - j >= 0 && i + j < n && s[i - j] == s[i + j]) {
                j++;
            }
            if (2 * j - 1 > b - a) {
                a = i - (j - 1);
                b = i + j;
            } 

            // check even
            if (i + 1 < n && s[i] == s[i + 1]) {
                j = 0;
                while (i - j >= 0 && i + j + 1 < n && s[i - j] == s[i + j + 1]) {
                    j++;
                }
                if (2 * j > b - a) {
                    a = i - (j - 1);
                    b = i + j + 1;
                } 
            }            
        }
        return s.substr(a, b - a);
    }
};

int main() {
    string s = "babad";

    Solution solution;
    cout << solution.longestPalindrome(s) << endl;
    return 0;
}