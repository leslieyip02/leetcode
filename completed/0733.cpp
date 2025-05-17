class Solution {
private:
    int directions[4][2] = {{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};

    void fill(vector<vector<int>>& image, int sr, int sc, int color, vector<vector<bool>>& visited) {
        int original = image[sr][sc];
        image[sr][sc] = color;
        visited[sr][sc] = true;
        for (int i = 0; i < 4; i++) {
            int r = sr + directions[i][0];
            int c = sc + directions[i][1];
            if (r < 0 || r >= image.size() || c < 0 || c >= image[0].size()) {
                continue;
            }
            if (image[r][c] != original || visited[r][c]) {
                continue;
            }
            fill(image, r, c, color, visited);
        }
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        vector<vector<bool>> visited(image.size(), vector<bool>(image[0].size(), false));
        fill(image, sr, sc, color, visited);
        return image;
    }
};
