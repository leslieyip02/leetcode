#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maximalNetworkRank(int n, vector<vector<int>>& roads) {
        vector<int> r(n);
        vector<vector<int>> m(n, vector<int>(n));
        for (auto road : roads) {
            r[road.front()]++;
            r[road.back()]++;
            m[road.front()][road.back()] = 1;
        }

        int x = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int c = r[i] + r[j];
                if (m[i][j] || m[j][i]) {
                    c--;
                }
                x = max(c, x);
            }
        }
        return x;
    }
};

int main() {
    vector<vector<int>> roads = {
        { 0, 1 },
        { 0, 3 },
        { 1, 2 },
        { 1, 3 },
        { 2, 3 },
        { 2, 4 }
    };
    int n = 5;

    Solution solution;
    cout << solution.maximalNetworkRank(n, roads) << endl;
    return 0;
}
