class Solution {
public:
    vector<int> findKDistantIndices(vector<int>& nums, int key, int k) {
        vector<bool> isKDistant(nums.size(), false);
        for (int i = 0; i < nums.size(); i++) {
            for (int j = max(i - k, 0); j <= min(i + k, (int) nums.size() - 1); j++) {
                if (nums[j] == key) {
                    isKDistant[i] = true;
                    break;
                }
            }
        }

        vector<int> indices;
        for (int i = 0; i < nums.size(); i++) {
            if (isKDistant[i]) {
                indices.push_back(i);
            }
        }
        return indices;
    }
};
