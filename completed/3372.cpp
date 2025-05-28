class Solution {
private:
    int bfs(int start, vector<vector<int>> &adjacents, int limit) {
        queue<int> next;
        next.push(start);
        unordered_set<int> visited;

        int count = 0;
        limit++;
        while (!next.empty() && limit--) {
            int size = next.size();
            while (size--) {
                int current = next.front();
                next.pop();
                if (visited.find(current) != visited.end()) {
                    continue;
                }
                visited.insert(current);
                count++;

                for (int adjacent : adjacents[current]) {
                    next.push(adjacent);
                }
            }
        }
        return count;
    }

    vector<vector<int>> getAdjacents(vector<vector<int>> &edges) {
        vector<vector<int>> adjacents(edges.size() + 1, vector<int>());
        for (vector<int> &edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacents[a].push_back(b);
            adjacents[b].push_back(a);
        }
        return adjacents;
    }

public:
    vector<int> maxTargetNodes(vector<vector<int>> &edges1, vector<vector<int>> &edges2, int k) {
        int n = edges1.size() + 1;
        int m = edges2.size() + 1;

        int best = 0;
        vector<vector<int>> adjacents2 = getAdjacents(edges2);
        for (int i = 0; i < m; i++) {
            best = max(bfs(i, adjacents2, k - 1), best);
        }

        vector<vector<int>> adjacents1 = getAdjacents(edges1);
        vector<int> answer(n, 0);
        for (int i = 0; i < n; i++) {
            answer[i] = bfs(i, adjacents1, k) + best;
        }
        return answer;
    }
};
