class Solution {
public:
    vector<string> getLongestSubsequence(vector<string>& words, vector<int>& groups) {
        int current = -1;
        vector<string> result;
        for (int i = 0; i < words.size(); i++) {
            if (groups[i] == current) {
                continue;
            }
            result.push_back(words[i]);
            current = groups[i];
        }
        return result;
    }
};
