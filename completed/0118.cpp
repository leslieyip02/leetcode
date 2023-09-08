#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        if (numRows == 1) {
            return {{ 1 }};
        }

        auto rows = generate(numRows - 1);
        vector<int> row = { 1 };
        for (int i = 0; i < numRows - 2; i++) {
            row.push_back(rows.back()[i] + rows.back()[i + 1]);
        }
        row.push_back(1);
        rows.push_back(row);
        return rows;
    }
};

int main() {
    // int numRows = 5;
    int numRows = 30;

    Solution solution;
    auto results = solution.generate(numRows);
    for (auto row : results) {
        for (int i : row) {
            cout << i << " ";
        }
        cout << endl;
    }
    return 0;
}