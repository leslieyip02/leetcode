class Solution {
public:
    int partitionDisjoint(vector<int>& nums) {
        vector<int> suffixMins(nums.size() + 1);
        suffixMins[nums.size()] = 1e7;
        for (int i = nums.size() - 1; i >= 0; i--) {
            suffixMins[i] = min(nums[i], suffixMins[i + 1]);
        }

        int left = 1;
        int prefixMax = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (prefixMax <= suffixMins[i]) {
                return i;
            }
            prefixMax = max(nums[i], prefixMax);
        }
        return -1;
    }
};
