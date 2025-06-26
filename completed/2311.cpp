class Solution {
public:
    int longestSubsequence(string s, int k) {
        string current = "";
        int index = s.length() - 1;
        while (index >= 0) {
            string next = s[index] + current;
            try {
                if (stoi(next, nullptr, 2) > k) {
                    break;
                }
            } catch (...) {
                break;
            }
            current = next;
            index--;
        }

        int length = current.length();
        while (index >= 0) {
            if (s[index] == '0') {
                length++;
            }
            index--;
        }
        return length;
    }
};
