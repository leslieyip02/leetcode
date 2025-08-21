class Solution {
public:
    int numSubmat(vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();
        vector<vector<int>> rows(m, vector<int>(n + 1));
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                rows[r][c + 1] = mat[r][c] == 1 ? rows[r][c] + 1 : 0;
            }
        }

        int count = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int length = rows[r][c + 1];
                for (int i = 0; i < m - r; i++) {
                    length = min(rows[r + i][c + 1], length);
                    if (length == 0) {
                        break;
                    }
                    count += length;
                }
            }
        }
        return count;
    }
};
