class Solution {
public:
    long long maximumOr(vector<int>& nums, int k) {
        int n = nums.size();
        vector<long long> prefixes(n);
        vector<long long> suffixes(n);

        prefixes[0] = nums[0];
        suffixes[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            prefixes[i] = prefixes[i - 1] | nums[i];
            suffixes[n - 1 - i] = suffixes[n - i] | nums[n - 1 - i];
        }

        long long maximum = 0;
        for (int i = 0; i < n; i++) {
            long long result = (long long) nums[i] << k;
            if (i > 0) result |= prefixes[i - 1];
            if (i < n - 1) result |= suffixes[i + 1];
            maximum = max(result, maximum);
        }
        return maximum;
    }
};
