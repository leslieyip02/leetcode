class Solution {
public:
    vector<int> applyOperations(vector<int>& nums) {
        vector<int> result;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums[i] == 0) {
                continue;
            }

            if (nums[i] == nums[i + 1]) {
                result.push_back(nums[i] * 2);
                nums[i + 1] = 0;
            } else {
                result.push_back(nums[i]);
            }
        }
        result.push_back(nums.back());
        while (result.size() < nums.size()) {
            result.push_back(0);
        }
        return result;
    }
};
