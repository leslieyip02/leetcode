#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> updated = vector<vector<int>>(m, vector<int>(n));
        // check left and up
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int d = m + n + 1;
                if (i > 0) {
                    d = min(updated[i - 1][j] + 1, d);
                }
                if (j > 0) {
                    d = min(updated[i][j - 1] + 1, d);
                }
                updated[i][j] = d;
            }
        }
        // check right and bottom
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                }
                int d = updated[i][j];
                if (i < m - 1) {
                    d = min(updated[i + 1][j] + 1, d);
                }
                if (j < n - 1) {
                    d = min(updated[i][j + 1] + 1, d);
                }
                updated[i][j] = d;
            }
        }
        return updated;
    }
};

int main() {
    vector<vector<int>> mat = {
        { 0, 0, 0 },
        { 0, 1, 0 },
        { 1, 1, 1 }
    };

    Solution solution;
    vector<vector<int>> updated = solution.updateMatrix(mat);
    for (auto row : updated) {
        for (auto col : row) {
            cout << col << ' ';
        }
        cout << endl;
    }
    return 0;
}