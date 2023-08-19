#include <iostream>
#include <cmath>
using namespace std;

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int n = (int) log10(x) + 1;
        bool ok = true;
        for (int i = 0; i < n / 2; i++) {
            long long m1 = ceil(pow(10, i + 1));
            long long m2 = ceil(pow(10, n - i));
            long long r1 = (x % m1) / (m1 / 10);
            long long r2 = (x % m2) / (m2 / 10);
            if (r1 != r2) {
                ok = false;
                break;
            }
        }
        return ok;
    }
};

int main() {
    int x = 121;

    Solution solution;
    cout << solution.isPalindrome(x) << endl;
    cout << solution.isPalindrome(-121) << endl;
    cout << solution.isPalindrome(0) << endl;
    cout << solution.isPalindrome(3) << endl;
    cout << solution.isPalindrome(123454321) << endl;
    cout << solution.isPalindrome(1234554321) << endl;
    return 0;
}
