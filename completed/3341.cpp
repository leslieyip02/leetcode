struct room {
    int x;
    int y;
    int t;
};

struct room_comparator {
    bool operator()(room const &a, room const &b) {
        return a.t != b.t ? a.t > b.t : (a.x + a.y) < (b.x + b.y);
    }
};

class Solution {
private:
    int directions[4][2] = {{ 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }};

public:
    int minTimeToReach(vector<vector<int>> &moveTime) {
        int n = moveTime.size();
        int m = moveTime[0].size();
        priority_queue<room, vector<room>, room_comparator> rooms;
        rooms.push({ 0, 0, 0 });
        vector<vector<bool>> visited(n, vector<bool>(m, false));
        while (!rooms.empty()) {
            room current = rooms.top();
            rooms.pop();
            if (current.x == m - 1 && current.y == n - 1) {
                return current.t;
            } else if (visited[current.y][current.x]) {
                continue;
            }
            visited[current.y][current.x] = true;
            for (int i = 0; i < 4; i++) {
                int x = current.x + directions[i][0];
                int y = current.y + directions[i][1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[y][x]) {
                    continue;
                }
                rooms.push({ x, y, max(current.t, moveTime[y][x]) + 1 });
            }
        }
        return -1;
    }
};
