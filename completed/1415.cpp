#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int backtrack(string& current, int n, int k) {
        if (current.size() == n) {
            return k - 1;
        }

        for (int i = 0; i < 3; i++) {
            if (!current.empty()) {
                int j = (int) current.back() - 'a';
                if (i == j) {
                    continue;
                }
            }

            char letter = (char) (i + 'a');
            current.push_back(letter);
            k = backtrack(current, n, k);
            if (k == 0) {
                return 0;
            }
            current.pop_back();
        }
        return k;
    }

public:
    string getHappyString(int n, int k) {
        string current = "";
        backtrack(current, n, k);
        return current;
    }
};
