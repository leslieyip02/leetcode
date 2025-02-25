class Solution {
public:
    int maxAbsoluteSum(vector<int>& nums) {
        int globalMin = 0;
        int globalMax = 0;
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            globalMin = min(currentSum, globalMin);
            globalMax = max(currentSum, globalMax);
        }
        return globalMax - globalMin;
    }
};
