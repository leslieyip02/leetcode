#include <iostream>
#include <cmath>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    long long minimumReplacement(vector<int>& nums) {
        long long operations = 0;
        int previous = nums.back();
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums[i] > previous) {
                int splits = ceil((nums[i] - 1) / previous);
                operations += splits;
                previous = floor(nums[i] / (splits + 1));
            } else {
                previous = nums[i];
            }
        }
        return operations;
    }
};

int main() {
    vector<int> nums = { 3, 9, 3 };
    // vector<int> nums = { 1, 2, 3, 4, 5 };
    // vector<int> nums = { 12, 9, 7, 6, 17, 19, 21 };

    Solution solution;
    cout << solution.minimumReplacement(nums) << endl;
    return 0;
}