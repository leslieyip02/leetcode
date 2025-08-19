class Solution {
public:
    long long zeroFilledSubarray(vector<int>& nums) {
        long long count = 0;
        int left = 0;
        int right = 0;
        while (left < nums.size()) {
            if (nums[left] != 0) {
                left++;
                right = left;
                continue;
            }

            if (right < nums.size() && nums[right] == 0) {
                right++;
                continue;
            }

            long long length = right - left;
            count += length * (length + 1) / 2;
            left = right;
        }
        return count;
    }
};
