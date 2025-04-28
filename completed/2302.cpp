class Solution {
public:
    long long countSubarrays(vector<int>& nums, long long k) {
        long long count = 0;
        int left = 0;
        int right = 0;
        long long sum = 0;
        int length = 0;
        while (left < nums.size()) {
            while (right < nums.size()) {
                sum += nums[right];
                length++;
                if ((sum * length) >= k) {
                    sum -= nums[right];
                    length--;
                    break;
                }
                right++;
            }
            count += length;

            sum -= nums[left];
            length--;
            left++;
        }
        return count;
    }
};
