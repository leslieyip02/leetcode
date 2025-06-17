class Solution {
private:
    int M = (int) 1e9 + 7;

    static const int size = (int) 1e5;
    long long f[size + 1];
    long long g[size + 1];

    long long choose(int n, int r) {
        return ((f[n] * g[r] % M) * g[n - r]) % M;
    }

    long long exp(long a, long b) {
        long long c = 1;
        while (b > 0) {
            if (b & 1) {
                c = (c * a) % M;
            }
            a = (a * a) % M;
            b >>= 1;
        }
        return c;
    }

public:
    Solution() {
        f[0] = 1;
        for (int i = 1; i <= size; i++) {
            f[i] = (f[i - 1] * i) % M;
        }

        // fermat's little theorem
        g[size] = exp(f[size], M - 2);
        for (int i = size; i >= 1; i--) {
            g[i - 1] = (g[i] * i) % M;
        }
    }

    int countGoodArrays(int n, int m, int k) {
        return ((m * choose(n - 1, k) % M) * exp(m - 1, n - k - 1)) % M;
    }
};
