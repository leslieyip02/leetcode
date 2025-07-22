class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int left = 0;
        int right = 0;
        int score = 0;
        int total = 0;
        unordered_set<int> seen;
        while (right < nums.size()) {
            auto itr = seen.find(nums[right]);
            while (itr != seen.end()) {
                seen.erase(nums[left]);
                total -= nums[left];
                left++;
                itr = seen.find(nums[right]);
            }

            seen.insert(nums[right]);
            total += nums[right];
            score = max(total, score);
            right++;
        }
        return score;
    }
};
