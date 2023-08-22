#include <iostream>
using namespace std;

class Solution {
public:
    string convertToTitle(int columnNumber) {
        string title = "";
        do {
            columnNumber--;
            title = (char) (columnNumber % 26 + 65) + title;
            columnNumber /= 26; 
        } while (columnNumber > 0);
        return title;
    }
};

int main() {
    int columnNumber = 1;

    Solution solution;
    cout << solution.convertToTitle(columnNumber) << endl;
    cout << solution.convertToTitle(2) << endl;
    cout << solution.convertToTitle(28) << endl;
    cout << solution.convertToTitle(701) << endl;
    cout << solution.convertToTitle(702) << endl;
    cout << solution.convertToTitle(703) << endl;
    return 0;
}
