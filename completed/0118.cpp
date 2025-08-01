class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;
        triangle.push_back({ 1 });

        for (int i = 1; i < numRows; i++) {
            vector<int> row;
            row.push_back(1);
            for (int j = 0; j < triangle[i - 1].size() - 1; j++) {
                row.push_back(triangle[i - 1][j] + triangle[i - 1][j + 1]);
            }
            row.push_back(1);
            triangle.push_back(row);
        }

        return triangle;
    }
};
