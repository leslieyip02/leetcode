class Solution {
private:
    int M = 1e9 + 7;

    int exp(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent & 1) {
                result *= base;
                result %= M;
            }
            exponent >>= 1;
            base *= base;
            base %= M;
        }
        return (int) result;
    }

public:
    int numSubseq(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());

        long total = 0;
        for (int i = 0; i < nums.size(); i++) {
            int complement = target - nums[i];
            int left = i;
            int right = nums.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] <= complement) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left <= i) {
                continue;
            }

            int index = left - i - 1;
            int count = exp(2, index);
            total = (total + count) % M;
        }
        return total;
    }
};
