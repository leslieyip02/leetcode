#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        vector<int> c(ratings.size(), 1);
        for (int i = 1; i < ratings.size(); i++) {
            if (ratings[i] > ratings[i - 1]) {
                c[i] = c[i - 1] + 1;
            }
        }
        for (int i = ratings.size() - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                c[i] = max(c[i], c[i + 1] + 1);
            }
        }

        int total = 0;
        for (int i : c) {
            total += i;
        }
        return total;
    }
};

int main() {
    vector<int> ratings = { 1, 0, 2 }; // 5

    Solution solution;
    cout << solution.candy(ratings) << endl;
    ratings = { 1, 2, 2 }; // 4
    cout << solution.candy(ratings) << endl;
    ratings = { 1, 1, 1 }; // 3
    cout << solution.candy(ratings) << endl;
    ratings = { 1, 2, 3 }; // 6
    cout << solution.candy(ratings) << endl;
    ratings = { 3, 2, 1 }; // 6
    cout << solution.candy(ratings) << endl;
    ratings = { 2, 3, 3, 2, 1, 2 }; // 11
    cout << solution.candy(ratings) << endl;
    ratings = { 1, 3, 2, 2, 1 }; // 7
    cout << solution.candy(ratings) << endl;
    return 0;
}
