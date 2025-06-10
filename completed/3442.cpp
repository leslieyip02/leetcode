class Solution {
public:
    int maxDifference(string s) {
        int f[26] = { 0 };
        for (char c : s) {
            f[(int) c - 'a']++;
        }

        int odd = 0;
        int even = s.length();
        for (int i = 0; i < 26; i++) {
            if (f[i] == 0) {
                continue;
            }
            if (f[i] % 2 == 0) {
                even = min(f[i], even);
            } else {
                odd = max(f[i], odd);
            }
        }
        return odd - even;
    }
};
