class Solution {
private:
    int M = (int) 1e9 + 7;

    void multiply(long a[26][26], long b[26][26]) {
        long c[26][26] = { 0 };
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    c[i][j] += (a[i][k] * b[k][j]) % M;
                    c[i][j] %= M;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                a[i][j] = c[i][j];
            }
        }
    }

public:
    int lengthAfterTransformations(string s, int t, vector<int>& nums) {
        long m[26][26] = { 0 };
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 1; j <= nums[i]; j++) {
                m[i][(i + j) % 26]++;
            }
        }

        long result[26][26] = { 0 };
        for (int i = 0; i < 26; i++) {
            result[i][i] = 1;
        }
        while (t > 0) {
            if (t % 2 == 1) {
                multiply(result, m);
            }
            multiply(m, m);
            t >>= 1;
        }

        int counts[26] = { 0 };
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s[i] - 'a']++;
        }

        long length = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                length += (counts[i] * result[i][j]) % M;
                length %= M;
            }
        }
        return length;
    }
};
