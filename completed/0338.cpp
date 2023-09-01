#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> countBits(int n) {
        vector<int> counts(n + 1);
        for (int i = 1; i <= n; i *= 2) {
            for (int j = 0; j < i && i + j <= n; j++) {
                counts[i + j] = counts[j] + 1;
            }
        }
        return counts;
    }
};

int main() {
    // int n = 5;
    int n = 32;

    Solution solution;
    auto results = solution.countBits(n);
    for (auto i : results) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}