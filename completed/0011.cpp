#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int maxArea(vector<int>& height) {
        int l = 0;
        int r = height.size() - 1;

        int v = 0;
        while (l < r) {
            v = max(min(height[l], height[r]) * (r - l), v);
            // for the same interval, keep the higher bar
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return v;
    }
};

int main() {
    vector<int> height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

    Solution solution;
    cout << solution.maxArea(height) << endl;
    height = { 1, 1 };
    cout << solution.maxArea(height) << endl;
    return 0;
}
