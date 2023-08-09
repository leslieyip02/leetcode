#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    int minimizeMax(vector<int>& nums, int p) {
        if (p == 0) {
            return 0;
        }

        sort(nums.begin(), nums.end());
        vector<int> d(nums.size() - 1);
        for (int i = 0; i < nums.size() - 1; i++) {
            d[i] = nums[i + 1] - nums[i];
        }

        int lo = 0;
        int hi = nums.back() - nums.front();
        int mid = (lo + hi) / 2;
        while (hi > lo) {
            if (enoughPairs(d, p, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
            mid = (lo + hi) / 2;
        }

        return mid;
    }

private:
    bool enoughPairs(vector<int> &d, int p, int t) {
        int n = 0;
        for (int i = 0; i < d.size() && n < p; i++) {
            if (d[i] <= t) {
                n++;
                i++;
            }
        }
        return n >= p;
    }
};

int main() {
    vector<int> nums = { 4, 2, 1, 2 };
    int p = 1;

    Solution solution;
    cout << solution.minimizeMax(nums, p) << endl;
    return 0;
}
