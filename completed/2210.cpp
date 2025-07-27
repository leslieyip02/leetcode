class Solution {
public:
    int countHillValley(vector<int>& nums) {
        vector<int> compressed;
        for (int num : nums) {
            if (compressed.empty() || num != compressed.back()) {
                compressed.push_back(num);
            }
        }

        int count = 0;
        for (int i = 1; i < compressed.size() - 1; i++) {
            bool left = compressed[i] < compressed[i - 1];
            bool right = compressed[i] < compressed[i + 1];
            count += left == right;
        }
        return count;
    }
};
