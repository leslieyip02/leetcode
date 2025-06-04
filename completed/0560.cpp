class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> prefixSums;
        prefixSums[0] = 1;

        int count = 0;
        int current = 0;
        for (int num : nums) {
            current += num;

            int target = current - k;
            auto itr = prefixSums.find(target);
            if (itr != prefixSums.end()) {
                count += itr->second;
            }
            prefixSums[current]++;
        }
        return count;
    }
};
