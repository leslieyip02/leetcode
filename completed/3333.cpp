class Solution {
private:
    const int M = 1e9 + 7;

public:
    int possibleStringCount(string word, int k) {
        vector<int> counts;
        int left = 0;
        while (left < word.length()) {
            int right = left + 1;
            while (right < word.length() && word[right] == word[left]) {
                right++;
            }
            int count = right - left;
            counts.push_back(count);
            left = right;
        }

        long long total = 1;
        for (int count : counts) {
            total = (count * total) % M;
        }
        if (counts.size() >= k) {
            return (int) total;
        }

        vector<int> f(k), g(k, 1);
        f[0] = 1;
        for (int i = 0; i < counts.size(); ++i) {
            vector<int> f_new(k);
            for (int j = 1; j < k; ++j) {
                f_new[j] = g[j - 1];
                if (j - counts[i] - 1 >= 0) {
                    f_new[j] = (f_new[j] - g[j - counts[i] - 1] + M) % M;
                }
            }
            vector<int> g_new(k);
            g_new[0] = f_new[0];
            for (int j = 1; j < k; ++j) {
                g_new[j] = (g_new[j - 1] + f_new[j]) % M;
            }
            f = move(f_new);
            g = move(g_new);
        }
        return (int) ((total - g[k - 1] + M) % M);
    }
};
