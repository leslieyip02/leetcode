#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int combinationSum4(vector<int>& nums, int target) {
        sort(nums.begin(), nums.end());
        vector<unsigned long long> w(target + 1, 0);
        for (int num : nums) {
            if (num > target) {
                break;
            }
            w[num] = 1;
        }

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                }
                w[i] += w[i - num];
            }
        }
        return w.back();
    }
};

int main() {
    vector<int> nums = { 1, 2, 3 };
    // vector<int> nums = { 3, 2, 1, 4 };
    int target = 4;

    Solution solution;
    cout << solution.combinationSum4(nums, target) << endl;
    return 0;
}
