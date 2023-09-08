#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Edge {
    int a;
    int b;
    int weight;
    int index;
};

class DisjointSet {
private:
    vector<int> parents;
    vector<int> sizes;

public:
    int maxSize;

    DisjointSet(int n) {
        parents.resize(n, -1);
        sizes.resize(n, 1);
        maxSize = 1;
    }

    int find(int x) {
        if (parents[x] == -1) {
            return x;
        }
        parents[x] = find(parents[x]);
        return parents[x];
    }

    bool unite(Edge& edge) {
        int i = find(edge.a);
        int j = find(edge.b);
        if (i != j) {
            if (sizes[i] < sizes[j]) {
                swap(i, j);
            }
            parents[j] = i;
            sizes[i] += sizes[j];
            maxSize = max(sizes[i], maxSize);
            return true;
        }
        return false;
    }
};

class Solution {
public:
    vector<vector<int>> findCriticalAndPseudoCriticalEdges(int n, vector<vector<int>>& edges) {
        int m = edges.size();
        vector<Edge> edgeStructs(m);
        for (int i = 0; i < m; i++) {
            edgeStructs[i].a = edges[i][0];
            edgeStructs[i].b = edges[i][1];
            edgeStructs[i].weight = edges[i][2];
            edgeStructs[i].index = i;
        }

        sort(edgeStructs.begin(), edgeStructs.end(),
            [] (const Edge& e1, const Edge& e2) {
                return e1.weight < e2.weight;
            });

        DisjointSet mst0(n);
        int w0 = 0;
        for (Edge& edge : edgeStructs) {
            if (mst0.unite(edge)) {
                w0 += edge.weight;
            }
        }

        vector<int> criticalEdges;
        vector<int> pseudoCriticalEdges;
        for (int i = 0; i < m; i++) {
            DisjointSet mst1(n);
            int w1 = 0;
            for (int j = 0; j < m; j++) {
                if (i != j && mst1.unite(edgeStructs[j])) {
                    w1 += edgeStructs[j].weight;
                }
            }
            if (mst1.maxSize < n || w1 > w0) {
                criticalEdges.push_back(edgeStructs[i].index);
            } else {
                DisjointSet mst2(n);
                mst2.unite(edgeStructs[i]);
                int w2 = edgeStructs[i].weight;
                for (int j = 0; j < m; j++) {
                    if (i != j && mst2.unite(edgeStructs[j])) {
                        w2 += edgeStructs[j].weight;
                    }
                }
                if (w2 == w0) {
                    pseudoCriticalEdges.push_back(edgeStructs[i].index);
                }
            }
        }

        return vector<vector<int>> { criticalEdges, pseudoCriticalEdges };
    }
};

int main() {
    int n = 5;
    vector<vector<int>> edges = {
        { 0, 1, 1 },
        { 1, 2, 1 },
        { 2, 3, 2 },
        { 0, 3, 2 },
        { 0, 4, 3 },
        { 3, 4, 3 },
        { 1, 4, 6 },
    };
    // int n = 4;
    // vector<vector<int>> edges = {
    //     { 0, 1, 1 },
    //     { 1, 2, 1 },
    //     { 2, 3, 1 },
    //     { 0, 3, 1 }
    // };
    // int n = 6;
    // vector<vector<int>> edges = {
    //     { 0, 1, 1 },
    //     { 1, 2, 1 },
    //     { 0, 2, 1 },
    //     { 2, 3, 4 },
    //     { 3, 4, 2 },
    //     { 3, 5, 2 },
    //     { 4, 5, 2 }
    // };

    Solution solution;
    auto results = solution.findCriticalAndPseudoCriticalEdges(n, edges);
    for (auto i : results[0]) {
        cout << i << ' ';
    }
    cout << endl;
    for (auto i : results[1]) {
        cout << i << ' ';
    }
    cout << endl;
    return 0;
}
