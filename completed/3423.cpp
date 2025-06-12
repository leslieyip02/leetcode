class Solution {
public:
    int maxAdjacentDistance(vector<int>& nums) {
        int distance = 0;
        for (int i = 0; i < nums.size(); i++) {
            distance = max(abs(nums[i] - nums[(i + 1) % nums.size()]), distance);
        }
        return distance;
    }
};
