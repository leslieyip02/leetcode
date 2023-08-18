#include <iostream>
using namespace std;

class Solution {
public:
    int myAtoi(string s) {
        long long n = 0;
        int sign = 1;
        bool readingDigits = false;
        for (char c : s) {
            if (isdigit(c)) {
                n *= 10;
                n += c - '0';
                readingDigits = true;
                if (n * sign >= UPPER) {
                    return UPPER;
                } else if (n * sign <= LOWER) {
                    return LOWER;
                }
            } else if (!readingDigits && (c == '+' || c == '-')) {
                if (c == '-') {
                    sign = -1;
                }
                readingDigits = true;
            } else {
                if (readingDigits || c != ' ') {
                    break;
                }
            }
        }
        return (int) n * sign;
    }

private:
    const int UPPER = ~(1 << 31);
    const int LOWER = 1 << 31;
};

int main() {
    string s = "42";

    Solution solution;
    cout << solution.myAtoi(s) << endl;
    cout << solution.myAtoi("      -42") << endl;
    cout << solution.myAtoi("+4193 with words") << endl;
    cout << solution.myAtoi("words and 987") << endl;
    cout << solution.myAtoi("+-12") << endl;
    cout << solution.myAtoi("-91283472332") << endl;
    cout << solution.myAtoi("-2147483648") << endl;
    return 0;
}
