class Solution {
public:
    int minRemoval(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());

        int removed = nums.size() - 1;
        int left = 0;
        int right = 0;
        while (right < nums.size()) {
            while ((long) nums[right] > (long) nums[left] * k) {
                left++;
            }
            removed = min((int) nums.size() - (right - left + 1), removed);
            right++;
        }
        return removed;
    }
};
