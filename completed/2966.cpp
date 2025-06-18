class Solution {
public:
    vector<vector<int>> divideArray(vector<int>& nums, int k) {
        int n = nums.size();
        vector<vector<int>> divided(n / 3, vector<int>(3, 0));

        sort(nums.begin(), nums.end());
        for (int i = 0; i < n; i += 3) {
            if (nums[i + 2] - nums[i] > k) {
                return vector<vector<int>>();
            }

            divided[i / 3][0] = nums[i];
            divided[i / 3][1] = nums[i + 1];
            divided[i / 3][2] = nums[i + 2];
        }
        return divided;
    }
};
