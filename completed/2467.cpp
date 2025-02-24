#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    int trace(int currentNode, int depth, vector<int>& amount, vector<unordered_set<int>>& adjLists, vector<int>& bobDepths, vector<bool>& visited) {
        int gained = amount[currentNode];
        if (bobDepths[currentNode] != -1) {
            if (bobDepths[currentNode] == depth) {
                gained /= 2;
            } else if (bobDepths[currentNode] < depth) {
                gained = 0;
            }
        }

        int profit = -1e9;
        for (int adj : adjLists[currentNode]) {
            if (visited[adj]) {
                continue;
            }

            visited[adj] = true;
            profit = max(trace(adj, depth + 1, amount, adjLists, bobDepths, visited), profit);
            visited[adj] = false;
        }
        if (profit == -1e9) {
            profit = 0;
        }
        return profit + gained;
    }

public:
    int mostProfitablePath(vector<vector<int>>& edges, int bob, vector<int>& amount) {
        int n = amount.size();
        vector<unordered_set<int>> adjLists(n);
        for (vector<int> edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjLists[a].insert(b);
            adjLists[b].insert(a);
        }

        queue<int> nodes;
        nodes.push(bob);
        vector<bool> visited(n);
        visited[bob] = true;
        vector<int> parents(n, -1);
        while (!nodes.empty()) {
            int current = nodes.front();
            if (current == 0) {
                break;
            }
            nodes.pop();

            for (int adj : adjLists[current]) {
                if (visited[adj]) {
                    continue;
                }

                nodes.push(adj);
                visited[adj] = true;
                parents[adj] = current;
            }
        }

        int current = 0;
        vector<int> path;
        while (current != -1) {
            path.push_back(current);
            current = parents[current];
        }

        vector<int> bobDepths(n, -1);
        for (int i = 0; i < path.size(); i++) {
            bobDepths[path[i]] = path.size() - 1 - i;
        }

        fill(visited.begin(), visited.end(), false);
        visited[0] = true;
        return trace(0, 0, amount, adjLists, bobDepths, visited);
    }
};
