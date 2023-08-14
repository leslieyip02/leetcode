#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        map<int, int> f;
        for (int n : nums) {
            f[n]++;
        }
        for (auto itr = f.rbegin(); itr != f.rend(); itr++) {
            if (itr->second >= k)
            {
                return itr->first;
            }
            k -= itr->second;
        }
        return -1;
    }
};

int main() {
    vector<int> nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k = 4;

    Solution solution;
    cout << solution.findKthLargest(nums, k) << endl;
    return 0;
}