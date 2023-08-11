#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<vector<int>> m;

    int choose(int amount, vector<int>& coins, int i) {
        if (amount == 0) {
            return 1;
        }
    
        if (m[i][amount] != -1) {
            return m[i][amount];
        } 

        int w = 0;
        if (coins[i] <= amount) {
            w += choose(amount - coins[i], coins, i);
        }
        if (i + 1 < coins.size()) {
            w += choose(amount, coins, i + 1);
        }
        m[i][amount] = w;
        return w;
    }

    int change(int amount, vector<int>& coins) {
        m.resize(coins.size(), vector<int>(amount + 1, -1));
        return choose(amount, coins, 0);
    }
};

int main() {
    int amount = 5;
    vector<int> coins = { 1, 2, 5 };

    Solution solution;
    cout << solution.change(amount, coins) << endl;
    return 0;
}
