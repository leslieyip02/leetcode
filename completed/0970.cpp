#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    vector<int> powerfulIntegers(int x, int y, int bound) {
        unordered_set<int> p = { 1, x };
        unordered_set<int> q = { 1, y };

        int a = x * x;
        while (a != 1 && a < bound) {
            p.insert(a);
            a *= x;
        }
        int b = y * y;
        while (b != 1 && b < bound) {
            q.insert(b);
            b *= y;
        }

        vector<int> ok;
        for (int i = 2; i <= bound; i++) {
            for (auto j : p) {
                if (q.find(i - j) != q.end()) {
                    ok.push_back(i);
                    break;
                }
            }
        }
        return ok;
    }
};

int main() {
    // int x = 2;
    // int y = 3;
    // int bound = 10;
    // int x = 3;
    // int y = 5;
    // int bound = 15;
    int x = 2;
    int y = 1;
    int bound = 10;

    Solution solution;
    auto results = solution.powerfulIntegers(x, y, bound);
    for (auto i : results) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
