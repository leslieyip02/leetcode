class Solution {
public:
    long long countSubarrays(vector<int>& nums, int k) {
        int maximum = 0;
        for (int num : nums) {
            maximum = max(num, maximum);
        }

        long long count = 0;
        int left = 0;
        int right = 0;
        int appearances = 0;
        while (left < nums.size()) {
            while (right < nums.size() && appearances < k) {
                if (nums[right] == maximum) {
                    appearances++;
                }
                right++;
            }
            if (appearances < k) {
                break;
            }

            count += nums.size() - right + 1;
            if (nums[left] == maximum) {
                appearances--;
            }
            left++;
        }
        return count;
    }
};
