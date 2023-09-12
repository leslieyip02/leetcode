#include <iostream>
#include <vector>
#include <unordered_set>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minDeletions(string s) {
        vector<int> f(26, 0);
        for (char c : s) {
            f[(int) c - 97]++;
        }
        sort(f.begin(), f.end());

        int m = 0;
        unordered_set<int> ff;
        for (int i = 25; i >= 0; i--) {
            if (f[i] == 0) {
                break;
            }

            int n = f[i];
            while (n > 0 && ff.find(n) != ff.end()) {
                n--;
            }
            ff.insert(n);
            m += f[i] - n;
        }
        return m;
    }
};

int main() {
    string s = "aaabbbcc";

    Solution solution;
    cout << solution.minDeletions(s) << endl;
    cout << solution.minDeletions("aab") << endl;
    cout << solution.minDeletions("ceabaacb") << endl;
    cout << solution.minDeletions("aabb") << endl;
    return 0;
}
