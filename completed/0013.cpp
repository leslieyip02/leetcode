#include <iostream>
#include <map>
using namespace std;

class Solution {
private:
    map<char, int> values = {
        { 'I', 1 },
        { 'V', 5 },
        { 'X', 10 },
        { 'L', 50 },
        { 'C', 100 },
        { 'D', 500 },
        { 'M', 1000 }
    };

public:
    int romanToInt(string s) {
        int integerValue = 0;
        int largest = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digitValue = values[s[i]];
            if (digitValue < largest) {
                digitValue *= -1;
            } else {
                largest = digitValue;
            }
            integerValue += digitValue;
        }
        return integerValue;
    }
};

int main() {
    string s = "III";

    Solution solution;
    cout << solution.romanToInt(s) << endl;
    cout << solution.romanToInt("LVIII") << endl;
    cout << solution.romanToInt("MCMXCIV") << endl;
    return 0;
}