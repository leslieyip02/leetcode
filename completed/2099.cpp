class Solution {
public:
    vector<int> maxSubsequence(vector<int>& nums, int k) {
        auto minimum_index = [&nums](const int& i, const int& j) {
            return nums[i] > nums[j];
        };

        vector<bool> included(nums.size(), true);
        priority_queue<int, vector<int>, decltype(minimum_index)> indices(minimum_index);
        for (int i = 0; i < nums.size(); i++) {
            indices.push(i);
            if (indices.size() > k) {
                included[indices.top()] = false;
                indices.pop();
            }
        }

        vector<int> subsequence;
        for (int i = 0; i < nums.size(); i++) {
            if (included[i]) {
                subsequence.push_back(nums[i]);
            }
        }
        return subsequence;
    }
};
