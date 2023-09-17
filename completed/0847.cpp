#include <iostream>
#include <vector>
#include <queue>
#include <map>
#include <unordered_set>
using namespace std;    

struct Node {
    int index;
    int mask;
    int cost;

    Node(int index, int mask, int cost) {
        this->index = index;
        this->mask = mask;
        this->cost = cost;
    }
};

class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        int n = graph.size();
        int ok = (1 << n) - 1; // all bits set to 1

        queue<Node> nodes;
        map<int, unordered_set<int>> visited;
        for (int i = 0; i < n; i++) {
            int mask = 1 << i;
            nodes.push(Node(i, mask, 1));
            visited[i] = { mask };
        }

        while (!nodes.empty()) {
            Node current = nodes.front();
            nodes.pop();

            for (auto adjacent : graph[current.index]) {
                int mask = current.mask | (1 << adjacent);
                if (mask == ok) {
                    return current.cost;
                }

                if (visited[adjacent].find(mask) == visited[adjacent].end()) {
                    nodes.push(Node(adjacent, mask, current.cost + 1));
                    visited[adjacent].insert(mask);
                }
            }
        }

        return 0;
    }
};

int main() {
    vector<vector<int>> graph = { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } };

    Solution solution;
    cout << solution.shortestPathLength(graph) << endl;
    return 0;
}
