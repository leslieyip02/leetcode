#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        vector<vector<int>> w;
        for (int i = 0; i < obstacleGrid.size(); i++) {
            w.push_back(vector<int>(obstacleGrid[i].size()));
        }

        if (!obstacleGrid[0][0]) {
            w[0][0] = 1;
        }
        for (int i = 0; i < obstacleGrid.size(); i++) {
            for (int j = 0; j < obstacleGrid[i].size(); j++) {
                if (obstacleGrid[i][j]) {
                    continue;
                }
                if (j > 0 && !obstacleGrid[i][j - 1]) {
                    w[i][j] += w[i][j - 1];
                }
                if (i > 0 && j < obstacleGrid[i].size() && !obstacleGrid[i - 1][j]) {
                    w[i][j] += w[i - 1][j];
                }
            }
        }
        return w.back().back();
    }
};

int main()
{
    vector<vector<int>> obstacleGrid = {{ 0 }};

    Solution solution;
    cout << solution.uniquePathsWithObstacles(obstacleGrid) << endl;
    return 0;
}
