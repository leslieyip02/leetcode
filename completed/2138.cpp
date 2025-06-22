class Solution {
public:
    vector<string> divideString(string s, int k, char fill) {
        vector<string> groups;
        for (int i = 0; i < s.length(); i += k) {
            string group = "";
            int limit = min((int) s.length(), i + k);
            for (int j = i; j < limit; j++) {
                group += s[j];
            }
            while (group.length() < k) {
                group += fill;
            }
            groups.push_back(group);
        }
        return groups;
    }
};
