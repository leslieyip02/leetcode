class Solution {
public:
    vector<long long> mostFrequentIDs(vector<int>& nums, vector<int>& freq) {
        set<pair<long long, int>> ids;
        unordered_map<int, set<pair<long long, int>>::iterator> itrs;

        vector<long long> ans(nums.size());
        for (int i = 0; i < nums.size(); i++) {
            long long count = freq[i];
            if (itrs.find(nums[i]) != itrs.end()) {
                count += itrs[nums[i]]->first;
                ids.erase(itrs[nums[i]]);
            }

            auto [itr, _] = ids.insert({ count, nums[i] });
            itrs[nums[i]] = itr;

            ans[i] = ids.rbegin()->first;
        }
        return ans;
    }
};
