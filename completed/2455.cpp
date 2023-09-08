#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int averageValue(vector<int>& nums) {
        int v = 0;
        int n = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                v += num;
                n++;
            }
        }
        return n > 0 ? v / n : 0;
    }
};

int main() {
    vector<int> nums = { 1, 3, 6, 10, 12, 15 };

    Solution solution;
    cout << solution.averageValue(nums) << endl;
    return 0;
}
