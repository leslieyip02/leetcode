class Solution {
private:
    void dfs(
        int current,
        int parent,
        vector<int>& nums,
        vector<vector<int>>& adjacencyLists,
        vector<int>& subtreeSums,
        vector<unordered_set<int>>& children
    ) {
        subtreeSums[current] = nums[current];
        children[current].insert(current);

        for (int adjacent : adjacencyLists[current]) {
            if (adjacent == parent) {
                continue;
            }

            dfs(adjacent, current, nums, adjacencyLists, subtreeSums, children);
            subtreeSums[current] ^= subtreeSums[adjacent];
            children[current].insert(children[adjacent].begin(), children[adjacent].end());
        }
    }

public:
    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        int n = nums.size();
        vector<vector<int>> adjacencyLists(n);
        for (vector<int>& edge : edges) {
            adjacencyLists[edge[0]].push_back(edge[1]);
            adjacencyLists[edge[1]].push_back(edge[0]);
        }

        vector<int> subtreeSums(n);
        vector<unordered_set<int>> children(n);
        dfs(0, -1, nums, adjacencyLists, subtreeSums, children);

        int minimum = 1e9;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int score1, score2, score3;
                if (children[i].find(j) != children[i].end()) {
                    score1 = subtreeSums[j];
                    score2 = subtreeSums[i] ^ subtreeSums[j];
                    score3 = subtreeSums[0] ^ subtreeSums[i];
                } else if (children[j].find(i) != children[j].end()) {
                    score1 = subtreeSums[i];
                    score2 = subtreeSums[j] ^ subtreeSums[i];
                    score3 = subtreeSums[0] ^ subtreeSums[j];
                } else {
                    score1 = subtreeSums[i];
                    score2 = subtreeSums[j];
                    score3 = subtreeSums[0] ^ subtreeSums[i] ^ subtreeSums[j];
                }

                int score = max(score1, max(score2, score3)) - min(score1, min(score2, score3));
                minimum = min(score, minimum);
            }
        }
        return minimum;
    }
};
