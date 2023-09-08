#include <iostream>
using namespace std;

class Solution {
private:
    char letters[7] = { 'I', 'V', 'X', 'L', 'C', 'D', 'M' };

public:
    string intToRoman(int num) {
        int powerOfTen = 0;
        string roman = "";
        while (num > 0) {
            string section = "";
            int digit = num % 10;
            if (digit % 5 == 4) {
                section += letters[powerOfTen * 2]; 
                section += letters[powerOfTen * 2 + 1 + digit / 5];
            } else {
                if (digit >= 5) {
                    section = letters[powerOfTen * 2 + 1];
                    digit -= 5;
                }

                while (digit-- > 0) {
                    section += letters[powerOfTen * 2];
                }
            }

            roman = section + roman;
            num /= 10;
            powerOfTen++;
        }
        return roman;
    }
};

int main() {
    int num = 3;

    Solution solution;
    cout << solution.intToRoman(num) << endl;
    cout << solution.intToRoman(58) << endl;
    cout << solution.intToRoman(1994) << endl;
    return 0;
}