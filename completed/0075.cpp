#include <vector>
using namespace std;

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int f[3];
        for (int num : nums) {
            f[num]++;
        }
        int c = 0;
        for (int i = 0; i < nums.size(); i++) {
            while (f[c] == 0) {
                c++;
            }
            nums[i] = c;
            f[c]--;
        }
    }
};
