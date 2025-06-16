class Solution {
public:
    int maximumDifference(vector<int>& nums) {
        int result = -1;
        int smallest = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            int diff = nums[i] - smallest;
            if (diff > 0) {
                result = max(diff, result);
            }
            smallest = min(nums[i], smallest);
        }
        return result;
    }
};
