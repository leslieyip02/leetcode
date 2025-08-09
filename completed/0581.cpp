class Solution {
public:
    int findUnsortedSubarray(vector<int>& nums) {
        vector<int> prefixMax(nums.size() + 1, nums[0]);
        for (int i = 0; i < nums.size(); i++) {
            prefixMax[i + 1] = max(nums[i], prefixMax[i]);
        }
        vector<int> suffixMin(nums.size() + 1, nums[nums.size() - 1]);
        for (int i = nums.size() - 1; i >= 0; i--) {
            suffixMin[i] = min(nums[i], suffixMin[i + 1]);
        }

        int start = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != prefixMax[i + 1] || nums[i] != suffixMin[i]) {
                start = i;
                break;
            }
        }
        if (start == -1) {
            return 0;
        }

        for (int i = nums.size() - 1; i >= 0; i--) {
            if (nums[i] != prefixMax[i + 1] || nums[i] != suffixMin[i]) {
                return i - start + 1;
            }
        }
        return 0;
    }
};

