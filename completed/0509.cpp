#include <iostream>
using namespace std;

class Solution {
public:
    int fib(int n) {
        // if (n <= 1) {
        //     return n;
        // }
        // return fib(n - 1) + fib(n - 2);

        if (n <= 1) {
            return n;
        }

        n--;
        int p = 0;
        int q = 1;
        int r = p + 1;
        while (--n) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
};

int main() {
    int n = 2;

    Solution solution;
    cout << solution.fib(n) << endl;
    cout << solution.fib(3) << endl;
    cout << solution.fib(4) << endl;
    cout << solution.fib(5) << endl;
    cout << solution.fib(6) << endl;
    cout << solution.fib(7) << endl;
    cout << solution.fib(8) << endl;
    return 0;
}