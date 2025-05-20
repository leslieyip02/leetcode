class Solution {
public:
    bool isZeroArray(vector<int>& nums, vector<vector<int>>& queries) {
        vector<int> added(nums.size() + 1);
        for (vector<int> query : queries) {
            int l = query[0];
            int r = query[1];
            added[l]++;
            added[r + 1]--;
        }

        int current = 0;
        for (int i = 0; i < nums.size(); i++) {
            current += added[i];
            if (current < nums[i]) {
                return false;
            }
        }
        return true;
    }
};
