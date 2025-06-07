class Solution {
public:
    string clearStars(string s) {
        vector<bool> removed(s.length(), false);
        vector<stack<int>> indices(26, stack<int>());
        for (int i = 0; i < s.length(); i++) {
            if (s[i] == '*') {
                removed[i] = true;
                for (int j = 0; j < 26; j++) {
                    if (indices[j].empty()) {
                        continue;
                    }
                    removed[indices[j].top()] = true;
                    indices[j].pop();
                    break;
                }
                continue;
            }
            indices[(int) s[i] - 'a'].push(i);
        }
        string cleared = "";
        for (int i = 0; i < s.length(); i++) {
            if (removed[i]) {
                continue;
            }
            cleared += s[i];
        }
        return cleared;
    }
};
