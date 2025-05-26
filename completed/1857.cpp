class Solution {
public:
    int largestPathValue(string colors, vector<vector<int>>& edges) {
        vector<vector<int>> adjacents(colors.length(), vector<int>());
        vector<int> indegrees(colors.length(), 0);
        for (vector<int> &edge : edges) {
            int a = edge[0];
            int b = edge[1];
            adjacents[a].push_back(b);
            indegrees[b]++;
        }

        queue<int> indices;
        for (int i = 0; i < colors.length(); i++) {
            if (indegrees[i] == 0) {
                indices.push(i);
            }
        }

        vector<vector<int>> dp(colors.length(), vector<int>(26, 0));
        vector<bool> visited(colors.length(), false);
        while (!indices.empty()) {
            int index = indices.front();
            indices.pop();

            if (visited[index]) {
                return -1;
            }
            visited[index] = true;

            int color = (int) colors[index] - 'a';
            dp[index][color]++;
            for (int adjacent : adjacents[index]) {
                for (int i = 0; i < 26; i++) {
                    dp[adjacent][i] = max(dp[index][i], dp[adjacent][i]);
                }

                indegrees[adjacent]--;
                if (indegrees[adjacent] == 0) {
                    indices.push(adjacent);
                }
            }
        }

        int longest = 0;
        for (int i = 0; i < colors.length(); i++) {
            if (!visited[i]) {
                return -1;
            }
            for (int j = 0; j < 26; j++) {
                longest = max(dp[i][j], longest);
            }
        }
        return longest;
    }
};
