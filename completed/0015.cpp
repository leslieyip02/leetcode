#include <iostream>
#include <vector>
#include <set>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        map<int, int> lastIndex;
        for (int i = 0; i < nums.size(); i++) {
            lastIndex[nums[i]] = i;
        }

        set<vector<int>> triplets;
        for (int i = 0; i < nums.size() - 2; i++) {
            if (nums[i] > 0) {
                break;
            }

            for (int j = i + 1; j < nums.size() - 1; j++) {
                int k = -(nums[i] + nums[j]);
                auto itr = lastIndex.find(k);
                if (itr != lastIndex.end() && itr->second > j) {
                    triplets.insert({ nums[i], nums[j], k });
                }

                // skip to last index of current number
                // so that the next iteration skips the current number
                j = lastIndex[nums[j]];
            }

            // move on to next number
            i = lastIndex[nums[i]];
        }
        return vector<vector<int>>(triplets.begin(), triplets.end());
    }
};

int main() {
    vector<int> nums = { -1, 0, 1, 2, -1, -4 };
    // vector<int> nums = { 0, 1, 1 };
    // vector<int> nums = { 0, 0, 0 };

    Solution solution;
    auto results =  solution.threeSum(nums);
    for (auto triplet : results) {
        for (auto i : triplet) {
            cout << i << ' ';
        }
        cout << endl;
    }
    return 0;
}