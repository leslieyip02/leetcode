#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    int sumImbalanceNumbers(vector<int>& nums) {
        int total = 0;
        for (int i = 0; i < nums.size(); i++) {
            int imbalance = 0;
            set<int> subarrayNums = { nums[i] };
            for (int j = i + 1; j < nums.size(); j++) {
                if (subarrayNums.find(nums[j]) == subarrayNums.end()) {
                    int adjacent = 0;
                    if (subarrayNums.find(nums[j] + 1) != subarrayNums.end()) {
                        adjacent++;
                    }
                    if (subarrayNums.find(nums[j] - 1) != subarrayNums.end()) {
                        adjacent++;
                    }

                    if (adjacent == 2) {
                        imbalance--;
                    } else if (adjacent == 0) {
                        imbalance++;
                    }
                }

                total += imbalance;
                subarrayNums.insert(nums[j]);
            }
        }
        return total;
    }
};

int main() {
    vector<int> nums = { 2, 3, 1, 4 };

    Solution solution;
    cout << solution.sumImbalanceNumbers(nums) << endl;
    nums = { 1, 3, 3, 3, 5 };
    cout << solution.sumImbalanceNumbers(nums) << endl;
    nums = { 1, 3, 2 };
    cout << solution.sumImbalanceNumbers(nums) << endl;
    return 0;
}