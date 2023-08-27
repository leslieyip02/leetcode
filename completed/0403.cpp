#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    bool canCross(vector<int>& stones) {
        if (stones[1] - stones[0] > 1) {
            return false;
        }

        vector<set<int>> dp(stones.size());
        dp[1].insert(1);
        for (int i = 2; i < stones.size(); i++) {
            for (int j = 1; j < i; j++) {
                for (int k : dp[j]) {
                    if (abs(k - (stones[i] - stones[j])) <= 1) {
                        dp[i].insert(stones[i] - stones[j]);
                    }
                }
            }
        }
        return dp.back().size() > 0;
    }
};

int main() {
    vector<int> stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
    // vector<int> stones = { 0, 1, 2, 3, 4, 8, 9, 11 };

    Solution solution;
    cout << (solution.canCross(stones) ? "true" : "false") << endl;
    return 0;
}