#include <iostream>
#include <vector>
#include <utility>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
        int left = 0;
        int right = 0;
        int taps = 0;
        while (right < n) {
            for (int i = 0; i <= n; i++) {
                if (i - ranges[i] <= left && i + ranges[i] >= right) {
                    right = i + ranges[i];
                }
            }

            if (left == right) {
                return -1;
            }

            taps++;
            left = right;
        }
        return taps;
    }
};

int main() {
    int n = 5;
    vector<int> ranges = { 3, 4, 1, 1, 0, 0 };

    Solution solution;
    cout << solution.minTaps(n, ranges) << endl;
    // n = 0;
    // ranges = { 0, 0, 0, 0 };
    // cout << solution.minTaps(n, ranges) << endl;
    // n = 8;
    // ranges = { 4, 0, 0, 0, 4, 0, 0, 0, 4 };
    // cout << solution.minTaps(n, ranges) << endl;
    // n = 8;
    // ranges = { 4, 0, 0, 0, 0, 0, 0, 0, 4 };
    // cout << solution.minTaps(n, ranges) << endl;
    // n = 9;
    // ranges = { 0, 5, 0, 3, 3, 3, 1, 4, 0, 4 };
    // cout << solution.minTaps(n, ranges) << endl;
    // n = 7;
    // ranges = { 1, 2, 1, 0, 2, 1, 0, 1 };
    // cout << solution.minTaps(n, ranges) << endl;
    // n = 35;
    // ranges = { 1, 0, 4, 0, 4, 1, 4, 3, 1, 1, 1, 2, 1, 4, 0, 3, 0, 3, 0, 3, 0, 5, 3, 0, 0, 1, 2, 1, 2, 4, 3, 0, 1, 0, 5, 2 };
    // cout << solution.minTaps(n, ranges) << endl;
    return 0;
}

/*

4,0,0,0,4,0,0,0,4
4 3 2 1 A 1 2 3 4

1,0,4,0,4,1,4,3,1,1,1,2,1,4,0,3,0,3,0,3,0,5,3,0,0,1,2,1,2,4,3,0,1,0,5,2
4 3 2 1 A 1 2 3 4 4 3 2 1 B 1 2 3 4 3 2 1 C 1 2 3 4 5 2 1 D 1 2 3 4 E 1
*/
