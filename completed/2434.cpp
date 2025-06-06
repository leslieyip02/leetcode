class Solution {
public:
    string robotWithString(string s) {
        vector<char> suffixes(s.length(), 'z');
        suffixes[s.length() - 1] = s[s.length() - 1];
        for (int i = s.length() - 2; i >= 0; i--) {
            suffixes[i] = s[i] < suffixes[i + 1] ? s[i] : suffixes[i + 1];
        }

        string smallest = "";
        stack<char> t;
        for (int i = 0; i < s.length(); i++) {
            while (!t.empty() && t.top() <= suffixes[i]) {
                smallest += t.top();
                t.pop();
            }

            if (s[i] <= suffixes[i]) {
                smallest += s[i];
            } else {
                t.push(s[i]);
            }
        }
        while (!t.empty()) {
            smallest += t.top();
            t.pop();
        }
        return smallest;
    }
};
