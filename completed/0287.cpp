#include <iostream>
#include <vector>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        unordered_set<int> p;
        for (int num : nums) {
            if (p.find(num) != p.end()) {
                return num;
            }
            p.insert(num);
        }
        return -1;
    }
};

int main() {
    vector<int> nums = { 1, 3, 4, 2, 2 };

    Solution solution;
    cout << solution.findDuplicate(nums) << endl;
    return 0;
}
