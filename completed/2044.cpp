class Solution {
private:
    int countSubsets(
        vector<int>& nums,
        int index,
        int current,
        int target
    ) {
        if (current == target) {
            return 1 << (nums.size() - index);
        }

        if (index == nums.size()) {
            return 0;
        }

        int take = countSubsets(nums, index + 1, current | nums[index], target);
        int skip = countSubsets(nums, index + 1, current, target);
        return take + skip;
    }

public:
    int countMaxOrSubsets(vector<int>& nums) {
        int target = 0;
        for (int num : nums) {
            target |= num;
        }
        return countSubsets(nums, 0, 0, target);
    }
};
