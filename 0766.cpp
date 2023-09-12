#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool isToeplitzMatrix(vector<vector<int>>& matrix) {
        for (int i = 0; i < matrix[0].size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                if (i + j >= matrix[0].size()) {
                    break;
                }
                if (matrix[j][i + j] != matrix[0][i]) {
                    return false;
                }
            }
        }
        for (int i = 1; i < matrix.size(); i++) {
            for (int j = 0; j < matrix[0].size(); j++) {
                if (i + j >= matrix.size()) {
                    break;
                }
                if (matrix[i + j][j] != matrix[i][0]) {
                    return false;
                }
            }
        }
        return true;
    }
};

int main() {
    vector<vector<int>> matrix = {
        { 1, 2, 3, 4 },
        { 5, 1, 2, 3 },
        { 9, 5, 1, 2 }
    };

    Solution solution;
    cout << (solution.isToeplitzMatrix(matrix) ? "true" : "false") << endl;
    return 0;
}
