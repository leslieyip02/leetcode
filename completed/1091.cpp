#include <iostream>
#include <vector>
#include <utility>
using namespace std;

class Solution {
private:
    vector<pair<int, int>> directions = {
        { 0, 1 },
        { 1, 1 },
        { 1, 0 },
        { 1, -1 },
        { 0, -1 },
        { -1, -1 },
        { -1, 0 },
        { -1, 1 }
    };

public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        if (grid[0][0] == 1 || grid.back().back() == 1) {
            return -1;
        }

        vector<vector<int>> d(grid.size(), vector<int>(grid.size(), -1));
        d[0][0] = 1;

        int p = 1;
        bool ok = true;
        for (int p = 1; ok; p++) {
            ok = false;
            for (int i = 0; i < grid.size(); i++) {
                for (int j = 0; j < grid.size(); j++) {
                    if (d[i][j] == p) {
                        for (auto dir : directions) {
                            int a = i + dir.first;
                            int b = j + dir.second;
                            if (a >= 0 && a < grid.size() &&
                                b >= 0 && b < grid.size() &&
                                grid[a][b] != 1 && d[a][b] == -1) {

                                d[a][b] = p + 1;
                                ok = true;
                            }
                        }
                    }
                }
            }
        }
        return d.back().back();
    }
};

int main() {
    vector<vector<int>> grid = {
        { 0, 0, 0, 0, 0 },
        { 1, 1, 1, 1, 0 },
        { 0, 0, 0, 0, 0 },
        { 0, 1, 1, 1, 1 },
        { 0, 0, 0, 0, 0 }
    };

    Solution solution;
    cout << solution.shortestPathBinaryMatrix(grid) << endl;
    return 0;
}
