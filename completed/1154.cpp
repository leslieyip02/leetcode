#include <cstdlib>
#include <iostream>
using namespace std;

class Solution {
public:
    int dayOfYear(string date) {
        int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int yyyy = stoi(date.substr(0, 4));
        int mm = stoi(date.substr(5, 7));
        int dd = stoi(date.substr(8));

        int day = dd;
        for (int i = 0; i < mm - 1; i++) {
            day += months[i];
        }
        if (mm > 2 && isLeapYear(yyyy)) {
            day++;
        }
        return day;
    }

private:
    bool isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
};
