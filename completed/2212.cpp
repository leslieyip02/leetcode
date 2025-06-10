class Solution {
private:
    pair<int, int> shoot(
        int current,
        int numArrows,
        vector<int>& aliceArrows
    ) {
        if (current == 0) {
            return { 0, 0 };
        }

        int required = aliceArrows[current] + 1;
        pair<int, int> skip = shoot(current - 1, numArrows, aliceArrows);
        if (numArrows < required) {
            return skip;
        }

        pair<int, int> compete = shoot(current - 1, numArrows - required, aliceArrows);
        compete.first += current;

        if (skip.first >= compete.first) {
            return skip;
        } else {
            compete.second |= (1 << current);
            return compete;
        }
    }

public:
    vector<int> maximumBobPoints(int numArrows, vector<int>& aliceArrows) {
        int mask = shoot(aliceArrows.size() - 1, numArrows, aliceArrows).second;
        vector<int> bobArrows(aliceArrows.size(), 0);
        int spent = 0;
        for (int i = 0; i < aliceArrows.size(); i++) {
            if (mask & (1 << i)) {
                bobArrows[i] = aliceArrows[i] + 1;
                spent += bobArrows[i];
            }
        }
        bobArrows[0] += numArrows - spent;
        return bobArrows;
    }
};

