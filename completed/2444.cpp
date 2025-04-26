class Solution {
public:
    long long countSubarrays(vector<int>& nums, int minK, int maxK) {
        long long count = 0;
        int left = -1;
        int minIndex = -1;
        int maxIndex = -1;
        for (int right = 0; right < nums.size(); right++) {
            if (nums[right] < minK || nums[right] > maxK) {
                left = right;
            }
            if (nums[right] == minK) {
                minIndex = right;
            }
            if (nums[right] == maxK) {
                maxIndex = right;
            }
            count += max(min(minIndex, maxIndex) - left, 0);
        }
        return count;
    }
};
