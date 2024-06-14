#include <vector>
using namespace std;

class Solution {
public:
    int minIncrementForUnique(vector<int>& nums) {
        int max = 1e5;
        vector<int> f(max + 1);
        for (int num : nums) {
            f[num]++;
        }

        int count = 0;
        for (int i = 0; i < max; i++) {
            if (f[i] > 1) {
                f[i + 1] += f[i] - 1;
                count += f[i] - 1;
            }
        }
        if (f[max] > 1) {
            count += (f[max] - 1) * f[max] / 2;
        }
        return count;
    }
};
