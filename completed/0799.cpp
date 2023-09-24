#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
    const int HEIGHT = 100;

public:
    double champagneTower(int poured, int query_row, int query_glass) {
        vector<vector<double>> tower(HEIGHT, vector<double>(HEIGHT));
        tower[0][0] = poured;
        for (int i = 1; i <= query_row; i++) {
            for (int j = 0; j <= i; j++) {
                double left = j > 0 && tower[i - 1][j - 1] > 1 ? (tower[i - 1][j - 1] - 1) / 2 : 0;
                double right = tower[i - 1][j] > 1 ? (tower[i - 1][j] - 1) / 2 : 0;
                tower[i][j] = left + right;
            }
        }
        return min(tower[query_row][query_glass], 1.0);
    }
};

int main() {
    int poured = 2;
    int query_row = 1;
    int query_glass = 1;

    Solution solution;
    cout << solution.champagneTower(poured, query_row, query_glass) << endl;
    cout << solution.champagneTower(20, 10, 10) << endl;
    cout << solution.champagneTower(100000009, 33, 17) << endl;
    return 0;
}
