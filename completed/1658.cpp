#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int minOperations(vector<int>& nums, int x) {
        if (x == 0) {
            return 0;
        }

        vector<int> left(nums.size(), 0);
        left[0] = nums.front();
        int rightSum = nums.back();
        map<int, int> right;
        right[nums.back()] = 1;
        for (int i = 1; i < nums.size(); i++) {
            left[i] = left[i - 1] + nums[i];
            rightSum += nums[nums.size() - 1 - i];
            right[rightSum] = i + 1;
        }

        bool ok = false;
        int moves = nums.size();
        auto itr = right.find(x);
        if (itr != right.end()) {
            moves = min(itr->second, moves);
            ok = true;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (left[i] > x) {
                break;
            }

            if (left[i] == x) {
                moves = min(i + 1, moves);
                ok = true;
            }

            auto itr = right.find(x - left[i]);
            if (itr != right.end() && i + itr->second < nums.size()) {
                moves = min(i + 1 + itr->second, moves);
                ok = true;
            }
        }
        return ok ? moves : -1;
    }
};

int main() {
    vector<int> nums = { 1, 1, 4, 2, 3 };
    int x = 5;

    Solution solution;
    cout << solution.minOperations(nums, x) << endl;

    nums = { 5, 6, 7, 8, 9 };
    x = 4;
    cout << solution.minOperations(nums, x) << endl;

    nums = { 3, 2, 20, 1, 1, 3 };
    x = 10;
    cout << solution.minOperations(nums, x) << endl;

    nums = { 1, 1 };
    x = 3;
    cout << solution.minOperations(nums, x) << endl;
    return 0;
}
