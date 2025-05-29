class Solution {
private:
    vector<int> distribute(vector<vector<int>> &edges) {
        vector<vector<int>> adjacents(edges.size() + 1, vector<int>());
        for (vector<int> edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacents[a].push_back(b);
            adjacents[b].push_back(a);
        }

        vector<int> distributed(edges.size() + 1, -1);
        queue<int> nodes;
        nodes.push(0);

        int depth = 0;
        while (!nodes.empty()) {
            int size = nodes.size();
            while (size--) {
                int current = nodes.front();
                distributed[current] = depth % 2;
                nodes.pop();

                for (int adjacent : adjacents[current]) {
                    if (distributed[adjacent] != -1) {
                        continue;
                    }
                    nodes.push(adjacent);
                }
            }
            depth++;
        }
        return distributed;
    }

public:
    vector<int> maxTargetNodes(vector<vector<int>>& edges1, vector<vector<int>>& edges2) {
        int n = edges1.size() + 1;
        int m = edges2.size() + 1;

        int even = 0;
        for (int node : distribute(edges2)) {
            even += node;
        }
        int best = max(even, m - even);

        int counts[2] = { 0, 0 };
        vector<int> distributed = distribute(edges1);
        for (int node : distributed) {
            counts[node]++;
        }
        vector<int> answer(n, 0);
        for (int i = 0; i < n; i++) {
            answer[i] = best + counts[distributed[i]];
        }
        return answer;
    }
};
