#include <iostream>
using namespace std;

class Solution {
public:
    int reverse(int x) {
        int y = 0;
        int z = x >= 0 ? 1 : -1;
        while (x != 0) {
            if (y > UPPER || y < LOWER) {
                return 0;
            }
            y *= 10;
            y += x % 10;
            x /= 10;
        }
        return (y > 0) == (z > 0) ? y : 0;
    }

private:
    const double UPPER = ~(1 << 31) / 10.0;
    const double LOWER = (1 << 31) / 10.0;
};

int main() {
    int x = 123;

    Solution solution;
    cout << solution.reverse(x) << endl;
    cout << solution.reverse(-123) << endl;
    cout << solution.reverse(120) << endl;
    cout << solution.reverse((1 << 31 - 1)) << endl;
    cout << solution.reverse(-10) << endl;
    cout << solution.reverse(1534236469) << endl;
    return 0;
}
