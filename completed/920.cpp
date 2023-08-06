#include <iostream>
using namespace std;

#define M (int) (1e9 + 7)
#define N 101
#define ll long long

class Solution {
public:
    int numMusicPlaylists(int n, int goal, int k) {
        ll dp[N][N] = { 0 };
        dp[0][0] = 1;
        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= min(i, n); j++) {
                dp[i][j] = (dp[i - 1][j - 1] * (n - j + 1)) % M;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % M;
                }
            }
        }
        return dp[goal][n];
    }
};

int main()
{
    int n = 3;
    int goal = 3;
    int k = 1;

    Solution solution;
    cout << solution.numMusicPlaylists(n, goal, k) << endl;
    return 0;
}
