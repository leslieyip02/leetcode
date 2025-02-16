#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool find(int index, vector<int>& sequence, int n, int mask) {
        if (index == sequence.size()) {
            return mask == ((1 << n) - 1);
        }
        if (sequence[index] != 0) {
            return find(index + 1, sequence, n, mask);
        }

        for (int i = n; i >= 1; i--) {
            if (mask & (1 << (i - 1))) {
                continue;
            }
            if (i != 1 && (index + i >= sequence.size() || sequence[index + i] != 0)) {
                continue;
            }

            sequence[index] = i;
            if (i != 1) {
                sequence[index + i] = i;
            }
            mask |= (1 << (i - 1));
            if (find(index + 1, sequence, n, mask)) {
                return true;
            }
            sequence[index] = 0;
            if (i != 1) {
                sequence[index + i] = 0;
            }
            mask ^= (1 << (i - 1));
        }
        return false;
    }

public:
    vector<int> constructDistancedSequence(int n) {
        vector<int> sequence((n - 1) * 2 + 1);
        find(0, sequence, n, 0);
        return sequence;
    }
};
