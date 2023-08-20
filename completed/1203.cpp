#include <iostream>
#include <vector>
using namespace std;

class Solution {
private:
    vector<int> topologicalSort(vector<vector<int>>& graph, vector<int>& indegree) {
        vector<int> visited;
        vector<int> stack;
        // find nodes without dependencies
        for (int i = 0; i < graph.size(); i++) {
            if (indegree[i] == 0) {
                stack.push_back(i);
            }
        }

        while (!stack.empty()) {
            int item1 = stack.back();
            stack.pop_back();
            visited.push_back(item1);

            for (int item2 : graph[item1]) {
                indegree[item2]--;
                // if the next item no longer has dependencies,
                if (!indegree[item2]) {
                    stack.push_back(item2);
                }
            }
        }

        bool cycle = visited.size() != graph.size();
        return cycle ? vector<int>() : visited;
    }

public:
    vector<int> sortItems(int n, int m, vector<int>& group, vector<vector<int>>& beforeItems) {
        int g = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = g++;
            }
        }

        vector<vector<int>> itemGraph(n, vector<int>());
        vector<int> itemIndegree(n);
        vector<vector<int>> groupGraph(g, vector<int>());
        vector<int> groupIndegree(g);
        for (int item2 = 0; item2 < n; item2++) {
            for (int item1 : beforeItems[item2]) {
                // add item1 as a dependency for item2
                itemGraph[item1].push_back(item2);
                itemIndegree[item2]++;

                int group1 = group[item1];
                int group2 = group[item2];
                // add group1 as a dependency for group2
                if (group1 != group2) {
                    groupGraph[group1].push_back(group2);
                    groupIndegree[group2]++;
                }
            }
        }

        // find topological order of items and groups
        // order items and groups independently
        vector<int> itemOrder = topologicalSort(itemGraph, itemIndegree);
        vector<int> groupOrder = topologicalSort(groupGraph, groupIndegree);

        // cyclic graph means impossible
        if (itemOrder.empty() || groupOrder.empty()) {
            return vector<int>();
        }

        // order items within each group
        vector<vector<int>> orderedGroups(g, vector<int>());
        for (int item : itemOrder) {
            orderedGroups[group[item]].push_back(item);
        }

        // order all items across groups
        vector<int> orderedItems(n);
        int i = 0;
        for (int groupIndex : groupOrder) {
            for (int item : orderedGroups[groupIndex]) {
                orderedItems[i++] = item;
            }
        }
        return orderedItems;
    }
};

int main() {
    int n = 8;
    int m = 2;
    vector<int> group = { -1, -1, 1, 0, 0, 1, 0, -1 };
    vector<vector<int>> beforeItems = {
        {},
        { 6 },
        { 5 },
        { 6 },
        { 3, 6 },
        {},
        {},
        {}
    };

    Solution solution;
    auto results = solution.sortItems(n, m, group, beforeItems);
    for (int item : results) {
        cout << item << ' ';
    }
    cout << endl;
    return 0;
}
