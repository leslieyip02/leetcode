class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int target = 0;
        for (int num : nums) {
            target = max(num, target);
        }

        int left = 0;
        int right = 0;
        int length = 1;
        while (right < nums.size()) {
            if (nums[right] != target) {
                length = max(right - left, length);
                left = right + 1;
            }
            right++;
        }

        if (left < nums.size()) {
            length = max(right - left, length);
        }

        return length;
    }
};
