#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int maxNonOverlapping(vector<int>& nums, int target) {
        // keep track of prefix sums and their index
        map<int, int> prefixSums;
        int count = 0;
        int currentSum = 0;
        int lastIndex = -1;
        prefixSums[0] = -1;
        for (int i = 0; i < nums.size(); i++) {
            currentSum += nums[i];
            auto itr = prefixSums.find(currentSum - target);
            if (itr != prefixSums.end() &&
                itr->second >= lastIndex) {

                count++;
                lastIndex = i;
            }
            prefixSums[currentSum] = i;
        }
        return count;
    }
};

int main() {
    vector<int> nums = { 1, 1, 1, 1, 1 };
    int target = 2;
    // vector<int> nums = { -1, 3, 5, 1, 4, 2, -9 };
    // int target = 6;
    // vector<int> nums = { 0, 0, 0 };
    // int target = 0;


    Solution solution;
    cout << solution.maxNonOverlapping(nums, target) << endl;
    return 0;
}