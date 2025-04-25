class Solution {
public:
    long long countInterestingSubarrays(vector<int>& nums, int modulo, int k) {
        unordered_map<int, int> counts;
        counts[0]++;
        long long result = 0;
        int prefix = 0;
        for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }
            result += counts[(prefix - k + modulo) % modulo];
            counts[prefix % modulo]++;
        }
        return result;
    }
};
