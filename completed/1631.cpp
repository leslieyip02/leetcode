#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct Cell {
    int x;
    int y;
    int effort;
    int height;
};

class CompareCell {
public:
    bool operator()(Cell c1, Cell c2) {
        return c1.effort > c2.effort;
    }
};

class Solution {
private:
    const int INF = 1e6 + 1;
    vector<vector<int>> dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        vector<vector<int>> dist(heights.size(), vector<int>(heights[0].size(), INF));
        dist[0][0] = 0;
        priority_queue<Cell, vector<Cell>, CompareCell> heap;
        Cell start;
        start.x = start.y = start.effort = 0;
        start.height = heights[0][0];
        heap.emplace(start);

        while (!heap.empty()) {
            Cell cell = heap.top();
            heap.pop();
            if (cell.effort > dist[cell.y][cell.x]) {
                continue;
            }
            if (cell.x == heights[0].size() - 1 && cell.y == heights.size() - 1) {
                return cell.effort;
            }

            for (auto dir : dirs) {
                int p = cell.x + dir.front();
                int q = cell.y + dir.back();
                if (p >= 0 && p < heights[0].size() &&
                    q >= 0 && q < heights.size()) {

                    int height = heights[q][p];
                    int effort = max(abs(height - cell.height), cell.effort);
                    if (effort < dist[q][p]) {
                        dist[q][p] = effort;

                        Cell next;
                        next.x = p;
                        next.y = q;
                        next.effort = effort;
                        next.height = height;
                        heap.emplace(next);
                    }
                }
            }
        }
        return INF;
    }
};

int main() {
    vector<vector<int>> heights = {
        { 1, 2, 2 },
        { 3, 8, 2 },
        { 5, 3, 5 }
    };

    Solution solution;
    /*
    cout << solution.minimumEffortPath(heights) << endl;

    heights = {
        { 1, 2, 1, 1, 1 },
        { 1, 2, 1, 2, 1 },
        { 1, 2, 1, 2, 1 },
        { 1, 2, 1, 2, 1 },
        { 1, 1, 1, 2, 1 }
    };
    cout << solution.minimumEffortPath(heights) << endl;

    heights = { { 1, 10, 6, 7, 9, 10, 4, 9 } };
    cout << solution.minimumEffortPath(heights) << endl;

    heights = { { 10, 8 }, { 10, 8 }, { 1, 2 }, { 10, 3 }, { 1, 3 }, { 6, 3 }, { 5, 2 } };
    cout << solution.minimumEffortPath(heights) << endl;
    */

    heights = {
        { 4, 3, 4, 10, 5, 5, 9, 2 },
        { 10, 8, 2, 10, 9, 7, 5, 6 },
        { 5, 8, 10, 10, 10, 7, 4, 2 },
        { 5, 1, 3, 1, 1, 3, 1, 9 },
        { 6, 4, 10, 6, 10, 9, 4, 6 }
    };
    cout << solution.minimumEffortPath(heights) << endl;
    return 0;
}
