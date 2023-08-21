#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int closest = (int) 1e5;
        sort(nums.begin(), nums.end());
        for (auto itr1 = nums.begin(); itr1 != nums.end(); itr1++) {
            for (auto itr2 = itr1 + 1; itr2 != nums.end(); itr2++) {
                int s0 = *itr1 + *itr2;
                auto itr3 = lower_bound(itr2 + 1, nums.end(), target - s0);
                if (itr3 == nums.end()) {
                    itr3--;
                }

                if (itr3 == itr2) {
                    continue;
                }
                int s1 = s0 + *itr3;
                if (abs(target - s1) < abs(target - closest)) {
                    closest = s1;
                }

                itr3--;
                if (itr3 == itr2) {
                    continue;
                }
                int s2 = s0 + *itr3;
                if (abs(target - s2) < abs(target - closest)) {
                    closest = s2;
                }
            }
        }
        return closest;
    }
};

int main() {
    // vector<int> nums = { -1, 2, 1, -4 };
    // vector<int> nums = { 0, 0, 0 };
    vector<int> nums = { 1, 2, 7, 13 };
    int target = 12;

    Solution solution;
    cout << solution.threeSumClosest(nums, target) << endl;
    return 0;
}