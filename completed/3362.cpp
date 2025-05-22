class Solution {
public:
    int maxRemoval(vector<int>& nums, vector<vector<int>>& queries) {
        sort(queries.begin(), queries.end(), [](const vector<int> &a, const vector<int> &b) {
            return a[0] < b[0];
        });

        priority_queue<int> rights;
        vector<int> added(nums.size() + 1);
        int current = 0;
        int queryIndex = 0;
        for (int i = 0; i < nums.size(); i++) {
            while (queryIndex < queries.size() && queries[queryIndex][0] == i) {
                rights.push(queries[queryIndex][1]);
                queryIndex++;
            }

            current += added[i];
            while (current < nums[i] && !rights.empty()) {
                if (rights.top() < i) {
                    break;
                }
                current++;
                added[rights.top() + 1]--;
                rights.pop();
            }

            if (current < nums[i]) {
                return -1;
            }
        }
        return rights.size();
    }
};
