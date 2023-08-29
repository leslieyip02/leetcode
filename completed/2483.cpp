#include <iostream>
using namespace std;

class Solution {
public:
    int bestClosingTime(string customers) {
        int y = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers[i] == 'Y') {
                y++;
            }
        }

        int n = 0;
        int h = 0;
        int m = y;
        for (int i = 0; i < customers.length(); i++) {
            if (customers[i] == 'Y') {
                y--;
            } else {
                n++;
            }

            int p = y + n;
            if (p < m) {
                h = i + 1;
                m = p;
            }
        }
        return h;
    }
};

int main() {
    string customers = "YYNY";

    Solution solution;
    cout << solution.bestClosingTime(customers) << endl;
    cout << solution.bestClosingTime("NNNNN") << endl;
    cout << solution.bestClosingTime("YYYY") << endl;
    return 0;
}