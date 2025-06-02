class Solution {
private:
    bool isMatch(int start, int length, const char* s, const char* a) {
        for (int i = 0; i < length; i++) {
            if (s[start + i] != a[i]) {
                return false;
            }
        }
        return true;
    }

public:
    vector<int> beautifulIndices(string s, string a, string b, int k) {
        const char* x = s.c_str();
        const char* y = a.c_str();
        const char* z = b.c_str();

        int m = s.length() - b.length();
        set<int> bIndices;
        for (int j = 0; j <= m; j++) {
            if (isMatch(j, b.length(), x, z)) {
                bIndices.insert(j);
            }
        }

        vector<int> indices;
        int n = s.length() - a.length();
        for (int i = 0; i <= n; i++) {
            if (!isMatch(i, a.length(), x, y)) {
                continue;
            }

            auto closest = bIndices.lower_bound(i - k);
            if (closest != bIndices.end() && abs(*closest - i) <= k) {
                indices.push_back(i);
            }
        }
        return indices;
    }
};
