#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool helper(int index, string pattern, int used, string& current) {
        if (index == pattern.size()) {
            return true;
        }

        int start, end;
        if (pattern[index] == 'I') {
            start = (int) current.back() - '0' + 1;
            end = 9;
        } else {
            start = 1;
            end = (int) current.back() - '0' - 1;
        }

        for (int i = start; i <= end; i++) {
            int mask = 1 << (i - 1);
            if (used & mask) {
                continue;
            }

            current.push_back((char) (i + '0'));
            used |= mask;
            if (helper(index + 1, pattern, used, current)) {
                return true;
            }
            used ^= mask;
            current.pop_back();
        }
        return false;
    }

    string generate(string pattern) {
        string current = "";
        for (int i = 1; i <= 9; i++) {
            current.push_back((char) (i + '0'));
            if (helper(0, pattern, (1 << (i - 1)), current)) {
                break;
            }
            current.pop_back();
        }
        return current;
    }

public:
    string smallestNumber(string pattern) {
        return generate(pattern);
    }
};
