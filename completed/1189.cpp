#include <iostream>
using namespace std;

class Solution {
public:
    int maxNumberOfBalloons(string text) {
        int f[26];
        for (char letter : text) {
            f[letter - 97]++;
        }

        int n = f['b' - 97];
        n = min(f['a' - 97], n);
        n = min(f['l' - 97] / 2, n);
        n = min(f['o' - 97] / 2, n);
        n = min(f['n' - 97], n);
        return n;
    }
};
