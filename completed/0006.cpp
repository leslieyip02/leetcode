#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string convert(string s, int numRows) {
        int m = numRows;  
        if (m >= 3) {
            m += numRows - 2;
        }
        vector<string> rows(numRows, "");
        for (int i = 0; i < s.length(); i++) {
            int r = i % m;
            if (r < numRows) {
                rows[r] += s[i];
            } else {
                r -= numRows;
                rows[numRows - r - 2] += s[i];
            }
        }
        string result = "";
        for (string row : rows) {
            result += row;
        }
        return result;
    }
};

int main() {
    string s = "PAYPALISHIRING";
    int numRows = 3;

    Solution solution;
    cout << solution.convert(s, numRows) << endl;
    return 0;
}