#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int search(vector<int>& nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        int k = (lo + hi) / 2;
        while (hi > lo) {
            if (k + 1 < nums.size() && nums[k] > nums[k + 1]) {
                k++;
                break;
            } else if (nums[k] < nums[hi]) {
                hi = k;
            } else {
                lo = k;
            }
            k = (lo + hi) / 2;
        }

        lo = target > nums.back() ? 0 : k;
        hi = target > nums.back() ? k : nums.size() - 1;
        int i = (lo + hi) / 2;
        while (hi > lo) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                hi = i - 1;
            } else {
                lo = i + 1;
            }
            i = (lo + hi) / 2;
        }
        return nums[i] == target ? i : -1;
    }
};

int main() {
    vector<int> nums = { 5, 1, 3 };
    int target = 1;

    Solution solution;
    cout << solution.search(nums, target) << endl;
    return 0;
}
