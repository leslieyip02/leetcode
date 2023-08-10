#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int lo = 0;
        int hi = matrix.size() - 1;
        int i = (lo + hi) / 2;
        while (hi > lo) {
            if (matrix[i].back() < target) {
                lo = i + 1;
            } else {
                hi = i;
            }
            i = (lo + hi) / 2;
        }

        lo = 0;
        hi = matrix[i].size() - 1;
        int j = (lo + hi) / 2;
        while (hi > lo) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                lo = j + 1;
            } else {
                hi = j;
            }
            j = (lo + hi) / 2;
        }
        return matrix[i][j] == target;
    }
};

int main() {
    vector<vector<int>> matrix;
    matrix.push_back(vector<int> { 1, 3, 5, 7 });
    matrix.push_back(vector<int> { 10, 11, 16, 20 });
    matrix.push_back(vector<int> { 23, 30, 34, 60 });
    int target = 13;

    Solution solution;
    cout << (solution.searchMatrix(matrix, target) ? "true" : "false") << endl;
    return 0;
}
