class Solution {
public:
    int findLHS(vector<int>& nums) {
        unordered_map<int, int> counts;     
        for (int num : nums) {
            counts[num]++;
        }

        int longest = 0;
        for (auto &[num, count] : counts) {
            auto itr = counts.find(num + 1);
            if (itr == counts.end()) {
                continue;
            }
            longest = max(count + itr->second, longest);
        }
        return longest;
    }
};
