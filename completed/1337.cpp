#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Row {
    int soldiers;
    int index;
};

class Solution {
public:
    vector<int> kWeakestRows(vector<vector<int>>& mat, int k) {
        vector<Row> rows(mat.size());
        for (int i = 0; i < mat.size(); i++) {
            rows[i].index = i;
            for (int j = 0; j < mat[i].size(); j++) {
                if (mat[i][j]) {
                    rows[i].soldiers++;
                } else {
                    break;
                }
            }
        }
        sort(rows.begin(), rows.end(), [](const Row& r1, const Row& r2) {
            return r1.soldiers == r2.soldiers
                ? r1.index < r2.index
                : r1.soldiers < r2.soldiers;
        });

        vector<int> weakest(k);
        for (int i = 0; i < k; i++) {
            weakest[i] = rows[i].index;
        }
        return weakest;
    }
};

int main() {
    vector<vector<int>> mat = {
        { 1, 1, 0, 0, 0 },
        { 1, 1, 1, 1, 0 },
        { 1, 0, 0, 0, 0 },
        { 1, 1, 0, 0, 0 },
        { 1, 1, 1, 1, 1 }
    };
    int k = 3;

    Solution solution;
    auto results = solution.kWeakestRows(mat, k);
    for (auto i : results) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
