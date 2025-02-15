#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool dfs(int current, int i) {
        if (i == current || i == 0 || current == 0) {
            return i == current;
        }

        int next = 0;
        int digit = 0;
        while (current > 0) {
            next += (current % 10) * pow(10, digit);
            current /= 10;
            if (dfs(current, i - next)) {
                return true;
            }
            digit++;
        }
        return false;
    }

    bool canPartition(int i) {
        return dfs(i * i, i);
    }

public:
    int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (canPartition(i)) {
                sum += i * i;
            }
        }
        return sum;
    }
};
