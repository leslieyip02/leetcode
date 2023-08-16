#include <iostream>
#include <vector>
#include <set>
using namespace std;

class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        int n = nums.size() - k + 1;
        vector<int> m(n, -1e5);
        multiset<int> c;
        for (int i = 0; i < k; i++) {
            c.insert(nums[i]);
        }
        m[0] = *c.rbegin();
        for (int i = 1; i < n; i++) {
            auto itr = c.find(nums[i - 1]);
            if (itr != c.end()) {
                c.erase(itr);
            }
            c.insert(nums[i + k - 1]);
            m[i] = *c.rbegin();
        }
        return m;
    }
};

int main() {
    vector<int> nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
    int k = 3;

    Solution solution;
    vector<int> m = solution.maxSlidingWindow(nums, k);
    for (int i : m) {
        cout << i << ' ';
    }
    cout << endl;
    return 0;
}