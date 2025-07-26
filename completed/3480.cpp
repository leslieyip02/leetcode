class Solution {
public:
    long long maxSubarrays(int n, vector<vector<int>>& conflictingPairs) {
        vector<vector<int>> lefts(n + 1);
        for (vector<int>& pair : conflictingPairs) {
            int start = min(pair[0], pair[1]);
            int end = max(pair[0], pair[1]);
            lefts[end].push_back(start);
        }

        long long count = 0;
        vector<long long> gains(n + 1);
        pair<int, int> nearest = { 0, 0 };
        for (int right = 1; right <= n; right++) {
            for (int left : lefts[right]) {
                if (left > nearest.first) {
                    nearest = { left, nearest.first };
                } else if (left > nearest.second) {
                    nearest = { nearest.first, left };
                }
            }

            count += right - nearest.first;
            if (nearest.first > 0) {
                gains[nearest.first] += nearest.first - nearest.second;
            }
        }
        return count + *max_element(gains.begin(), gains.end());
    }
};
