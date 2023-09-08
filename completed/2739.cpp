#include <iostream>
using namespace std;

class Solution {
public:
    int distanceTraveled(int mainTank, int additionalTank) {
        int d = 0;
        while (mainTank >= 5) {
            d += mainTank / 5 * 50;
            int e = min(mainTank / 5, additionalTank);
            additionalTank -= e;
            mainTank = mainTank % 5 + e;
        }
        d += mainTank * 10;
        return d;
    }
};

int main() {
    int mainTank = 5;
    int additionalTank = 10;

    Solution solution;
    cout << solution.distanceTraveled(5, 10) << endl;
    cout << solution.distanceTraveled(1, 2) << endl;
    return 0;
}