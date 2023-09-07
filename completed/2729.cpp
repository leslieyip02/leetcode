#include <iostream>
using namespace std;

class Solution {
public:
    bool isFascinating(int n) {
        if (n > 333) {
            return false;
        }

        bool d[9] = { false };
        for (int i = 1; i <= 3; i++) {
            int x = n * i;
            while (x > 0) {
                int y = x % 10;
                if (y == 0 || d[y - 1]) {
                    return false;
                }
                d[y - 1] = true;
                x /= 10;
            }
        }

        bool ok = true;
        for (bool z : d) {
            ok &= z;
        }
        return ok;
    }
};

int main() {
    // int n = 192;
    int n = 100;

    Solution solution;
    cout << (solution.isFascinating(n) ? "true" : "false") << endl;
    return 0;
}
