class Solution {
public:
    string triangleType(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        }

        bool ab = nums[0] == nums[1];
        bool bc = nums[1] == nums[2];
        if (ab && bc) {
            return "equilateral";
        } else if (ab || bc) {
            return "isosceles";
        } else {
            return "scalene";
        }
    }
};
