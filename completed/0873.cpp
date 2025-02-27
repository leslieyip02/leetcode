class Solution {
public:
    int lenLongestFibSubseq(vector<int>& arr) {
        vector<vector<int>> dp(arr.size(), vector(arr.size(), 0));
        unordered_map<int, int> indices;

        int longest = 0;
        for (int i = 0; i < arr.size(); i++) {
            indices[arr[i]] = i;

            for (int j = 0; j < i; j++) {
                int target = arr[i] - arr[j];
                if (target >= arr[j] || indices.find(target) == indices.end()) {
                    dp[j][i] = 2;
                } else {
                    int k = indices[target];
                    dp[j][i] = dp[k][j] + 1;
                }
                longest = max(dp[j][i], longest);
            }
        }
        return longest == 2 ? 0 : longest;
    }
};
