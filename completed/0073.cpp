class Solution {
public:
    void setZeroes(vector<vector<int>>& matrix) {
        int m = matrix.size();
        int n = matrix[0].size();

        bool firstColumnZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] != 0) {
                continue;
            }
            firstColumnZero = true;
            break;
        }
        bool firstRowZero = false;
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] != 0) {
                continue;
            }
            firstRowZero = true;
            break;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] != 0) {
                    continue;
                }
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] != 0) {
                continue;
            }
            for (int j = 1; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] != 0) {
                continue;
            }
            for (int i = 1; i < m;  i++) {
                matrix[i][j] = 0;
            }
        }

        if (firstColumnZero) {
            for (int i = 0; i < m;  i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
};
