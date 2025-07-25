class Solution {
public:
    int maxSum(vector<int>& nums) {
        set<int> candidates;
        for (int num : nums) {
            if (candidates.find(num) != candidates.end()) {
                continue;
            }
            candidates.insert(num);
        }

        if (*candidates.rbegin() <= 0) {
            return *candidates.rbegin();
        }

        int sum = 0;
        for (int candidate : candidates) {
            if (candidate > 0) {
                sum += candidate;
            }
        }
        return sum;
    }
};
