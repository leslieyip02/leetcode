class Solution {
public:
    vector<int> smallestSubarrays(vector<int>& nums) {
        int total = 0;
        for (int num : nums) {
            total |= num;
        }

        int m = 0;
        while (total > 0) {
            total >>= 1;
            m++;
        }

        int n = nums.size();
        int current = 0;
        vector<int> answer(n, 1);
        vector<vector<int>> rights(m, vector<int>(n + 1, n));
        for (int i = n - 1; i >= 0; i--) {
            current |= nums[i];

            for (int j = 0; j < m; j++) {
                rights[j][i] = rights[j][i + 1];
                if (nums[i] & (1 << j)) {
                    rights[j][i] = i;
                }

                if (current & (1 << j)) {
                    answer[i] = max(rights[j][i] - i + 1, answer[i]);
                }
            }
        }
        return answer;
    }
};
