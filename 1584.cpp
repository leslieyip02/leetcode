#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

struct Edge {
    int from;
    int to;
    int distance;
};

class Solution {
public:
    int minCostConnectPoints(vector<vector<int>>& points) {
        vector<Edge> edges;
        for (int i = 0; i < points.size(); i++) {
            int x1 = points[i].front();
            int y1 = points[i].back();
            for (int j = i + 1; j < points.size(); j++) {
                int x2 = points[j].front();
                int y2 = points[j].back();
                Edge edge;
                edge.from = i;
                edge.to = j;
                edge.distance = abs(x1 - x2) + abs(y1 - y2);
                edges.push_back(edge);
            }
        }
        sort(edges.begin(), edges.end(), [](const Edge& e1, const Edge& e2) {
            return e1.distance < e2.distance;
        });

        int index = 0;
        int distance = 0;
        map<int, vector<int>> groups;
        vector<int> connected(points.size(), -1);
        for (Edge edge : edges) {
            if (connected[edge.from] == -1 && connected[edge.to] == -1) {
                connected[edge.from] = connected[edge.to] = index;
                groups.insert({ index, { edge.from, edge.to } });
                index++;
            } else if (connected[edge.from] == -1) {
                groups[connected[edge.to]].push_back(edge.from);
                connected[edge.from] = connected[edge.to];
            } else if (connected[edge.to] == -1) {
                groups[connected[edge.from]].push_back(edge.to);
                connected[edge.to] = connected[edge.from];
            } else {
                if (connected[edge.from] != connected[edge.to]) {
                    for (int i : groups[connected[edge.to]]) {
                        groups[connected[edge.from]].push_back(i);
                        connected[i] = connected[edge.from];
                    }
                } else {
                    continue;
                }
            }
            distance += edge.distance;
            if (groups.size() == 1 && groups.begin()->second.size() == points.size()) {
                break;
            }
        }

        return distance;
    }
};

int main() {
    vector<vector<int>> points = {
        { 0, 0 },
        { 2, 2 },
        { 3, 10 },
        { 5, 2 },
        { 7, 0 }
    };

    Solution solution;
    cout << solution.minCostConnectPoints(points) << endl;

    points = {
        { -8, 14 },
        { 16, -18 },
        { -19, -13 },
        { -18, 19 },
        { 20, 20 },
        { 13, -20 },
        { -15, 9 },
        { -4, -8 }
    };
    cout << solution.minCostConnectPoints(points) << endl;

    /*
    points = {
        { 3, 12 },
        { -2, 5 },
        { -4, 1 }
    };
    cout << solution.minCostConnectPoints(points) << endl;

    points = {
        { 2, -3 },
        { -17, -8 },
        { 13, 8 },
        { -17, -15 }
    };
    cout << solution.minCostConnectPoints(points) << endl;

    points = {
        { 11, -6 },
        { 9, -19 },
        { 16, -13 },
        { 4, -9 },
        { 20, 4 },
        { 20, 7 },
        { -9, 18 },
        { 10, -15 },
        { -15, 3 },
        { 6, 6 }
    };
    cout << solution.minCostConnectPoints(points) << endl;
    */
    return 0;
}
