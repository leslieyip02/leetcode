#include <iostream>
#include <vector>
#include <set>
#include <algorithm>
using namespace std;

typedef long long ll;

class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        if (nums.size() < 4) {
            return vector<vector<int>>();
        }
        sort(nums.begin(), nums.end());
        return kSum(nums, target, 4, 0);
    }

    vector<vector<int>> kSum(vector<int>& nums, ll target, int k, int currentIndex) {
        set<vector<int>> ok;

        if (k == 2) {
            int lo = currentIndex;
            int hi = nums.size() - 1;
            while (lo < hi) {
                int current = nums[lo] + nums[hi];
                if (current == target) {
                    ok.insert({ nums[lo], nums[hi] });
                }

                if (current <= target) {
                    lo++;
                } else if (current >= target) {
                    hi--;
                }
            }
            return vector<vector<int>>(ok.begin(), ok.end());
        }

        for (int i = currentIndex; i < nums.size() - k + 1; i++) {
            auto results = kSum(nums, target - nums[i], k - 1, i + 1);
            for (auto result : results) {
                result.push_back(nums[i]);
                sort(result.begin(), result.end());
                ok.insert(result);
            }
        }
        return vector<vector<int>>(ok.begin(), ok.end());
    }
};

int main() {
    // vector<int> nums = { 1, 0, -1, 0, -2, 2 };
    // int target = 0;
    // vector<int> nums = { 2, 2, 2, 2, 2 };
    // int target = 8;
    // vector<int> nums = { 0 };
    // int target = 0;
    vector<int> nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
    int target = -294967296;

    Solution solution;
    auto results = solution.fourSum(nums, target);
    for (auto quadruplet : results) {
        for (int i : quadruplet) {
            cout << i << ' ';
        }
        cout << endl;
    }
    return 0;
}