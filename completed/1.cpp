#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        multimap<int, int> s;
        for (int i = 0; i < nums.size(); i++) {
            s.insert({ nums[i], i });
        }
        for (auto i : s) {
            for (auto [itr, end] = s.equal_range(target - i.first); itr != end; itr++) {
                if (itr->second != i.second) {
                    return { i.second, itr->second };
                }
            }
        }
        return { -1, -1 };
    }
};

int main()
{
    vector<int> nums = { 2, 7, 11, 15 };
    int target = 9;

    Solution solution;
    for (auto i : solution.twoSum(nums, target)) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}
