class Solution {
public:
    int partitionArray(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());

        int count = 1;
        int current = nums[0];
        for (int num : nums) {
            if (num - current > k) {
                count++;
                current = num;
            }
        }
        return count;
    }
};
