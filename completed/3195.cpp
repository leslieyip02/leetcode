class Solution {
public:
    int minimumArea(vector<vector<int>>& grid) {
        int x0 = grid.size();
        int y0 = grid[0].size();
        int x1 = 0;
        int y1 = 0;
        for (int y = 0; y < grid.size(); y++) {
            for (int x = 0; x < grid[0].size(); x++) {
                if (grid[y][x] != 1) {
                    continue;
                }

                x0 = min(x, x0);
                y0 = min(y, y0);
                x1 = max(x, x1);
                y1 = max(y, y1);
            }
        }
        return max((y1 - y0 + 1) * (x1 - x0 + 1), 0);
    }
};
