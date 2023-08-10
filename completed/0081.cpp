#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        return find(nums.begin(), nums.end(), target) != nums.end();
    }
};

int main() {
    vector<int> nums = { 1, 1 };
    int target = 0;

    Solution solution;
    cout << (solution.search(nums, target) ? "true" : "false") << endl;
    return 0;
}
