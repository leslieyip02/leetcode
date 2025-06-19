class Solution {
private:
    bool isSubsequence(string s, string t) {
        if (s.length() > t.length()) {
            return false;
        }

        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (s[i] == t[j]) {
                i++;
                if (i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }

public:
    int findLUSlength(vector<string>& strs) {
        sort(strs.begin(), strs.end(), [](string s, string t) {
            return s.length() > t.length();
        });

        unordered_set<string> subsequenced;
        for (int i = 0; i < strs.size(); i++) {
            string t = strs[i];
            for (int j = i + 1; j < strs.size(); j++) {
                string s = strs[j];
                if (isSubsequence(s, t)) {
                    subsequenced.insert(s);
                }
            }
        }

        for (string str : strs) {
            if (!subsequenced.contains(str)) {
                return str.length();
            }
        }
        return -1;
    }
};
