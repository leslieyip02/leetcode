#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePaths(int m, int n) {
        vector<vector<int>> g(m, vector<int>(n));
        g[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    g[i][j] += g[i - 1][j];
                }
                if (j > 0) {
                    g[i][j] += g[i][j - 1];
                }
            }
        }
        return g[m - 1][n - 1];
    }
};

int main() {
    int m = 3;
    int n = 7;

    Solution solution;
    cout << solution.uniquePaths(m, n) << endl;
    return 0;
}