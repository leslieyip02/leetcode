class Solution {
private:
    bool inBounds(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

public:
    void rotate(vector<vector<int>>& matrix) {
        int n = matrix.size();
        int m = ceil(n / 2.0);
        vector<vector<bool>> visited(m, vector<bool>(m, false));
        for (int dy = 0; dy < m; dy++) {
            for (int dx = 0; dx < m; dx++) {
                // top left corner
                int x00 = dx;
                int y00 = dy;
                if (visited[y00][x00]) {
                    continue;
                }

                // top right corner
                int x01 = n - 1 - dy;
                int y01 = dx;

                // bottom right corner
                int x11 = n - 1 - dx;
                int y11 = n - 1 - dy;

                // bottom left corner
                int x10 = dy;
                int y10 = n - 1 - dx;

                int tmp = matrix[y00][x00];
                matrix[y00][x00] = matrix[y10][x10];
                matrix[y10][x10] = matrix[y11][x11];
                matrix[y11][x11] = matrix[y01][x01];
                matrix[y01][x01] = tmp;

                visited[y00][x00] = true;
                if (inBounds(x10, y10, m)) visited[y10][x10] = true;
                if (inBounds(x11, y11, m)) visited[y11][x11] = true;
                if (inBounds(x01, y01, m)) visited[y01][x01] = true;
            }
        }
    }
};
