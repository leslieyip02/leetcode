#include <iostream>
using namespace std;

class Solution {
private:
    const int M = 1e9 + 7;

public:
    int countOrders(int n) {
        unsigned long long c = 1;
        for (int i = 2; i <= n; i++) {
            c *= (2 * i - 1) * i;
            c %= M;
        }
        return (int) c;
    }
};

int main() {
    int n = 2;

    Solution solution;
    cout << solution.countOrders(n) << endl;
    cout << solution.countOrders(3) << endl;
    return 0;
}
