#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> m;

    bool validPrefix(vector<int>& nums, int index) {
        if (index < 0) {
            return true;
        }
        if (m[index] != -1) {
            return m[index];
        }

        bool ok = false;

        // case 1
        if (index >= 1 && nums[index] == nums[index - 1]) {
            ok |= validPrefix(nums, index - 2);
        }

        // case 2
        if (index >= 2 && nums[index] == nums[index - 1] && nums[index] == nums[index - 2]) {
            ok |= validPrefix(nums, index - 3);
        }

        // case 3
        if (index >= 2 && nums[index] == nums[index - 1] + 1 && nums[index - 1] == nums[index - 2] + 1) {
            ok |= validPrefix(nums, index - 3);
        }

        m[index] = ok;
        return ok;
    }

    bool validPartition(vector<int>& nums) {
        m.resize(nums.size(), -1);
        bool ok = validPrefix(nums, nums.size() - 1);
        return ok;
    }
};

int main() {
    vector<int> nums = { 803201, 803201, 803201, 803201, 803202, 803203 };

    Solution solution;
    cout << (solution.validPartition(nums) ? "true" : "false") << endl;
    return 0;
}
