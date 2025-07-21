class Solution {
public:
    string makeFancyString(string s) {
        string fancy = "";
        for (int i = 0; i < s.length(); i++) {
            fancy += s[i];
            if (i + 1 >= s.length() || s[i + 1] != s[i]) {
                continue;
            }

            fancy += s[i];
            while (i + 1 < s.length() && s[i + 1] == s[i]) {
                i++;
            }
        }
        return fancy;
    }
};
