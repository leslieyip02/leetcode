#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int findLongestChain(vector<vector<int>>& pairs) {
        sort(pairs.begin(), pairs.end(), [](const auto& p1, const auto&p2) {
            return p1.back() < p2.back();
        });

        int m = 0;
        int n = -10000;
        for (auto p : pairs) {
            if (p.front() > n) {
                m++;
                n = p.back();
            }
        }
        return m;
    }
};

int main() {
    vector<vector<int>> pairs = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
    // vector<vector<int>> pairs = { { 1, 2 }, { 7, 8 }, { 4, 5 } };
    // vector<vector<int>> pairs = {
    //     { -6, 9 },
    //     { 1, 6 },
    //     { 8, 10 },
    //     { -1, 4 },
    //     { -6, -2 },
    //     { -9, 8 },
    //     { -5, 3 },
    //     { 0, 3 }
    // };
    // vector<vector<int>> pairs = {
    //     { 7, 9 },
    //     { 4, 5 },
    //     { 7, 9 },
    //     { -7,-1 }, 
    //     { 0, 10 },
    //     { 3, 10 },
    //     { 3, 6 },
    //     { 2, 3 }
    // };

    Solution solution;
    cout << solution.findLongestChain(pairs) << endl;
    return 0;
}