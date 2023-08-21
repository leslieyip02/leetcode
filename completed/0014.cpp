#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string prefix = "";
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.size(); j++) {
                if (i >= strs[j].length() || strs[j][i] != strs[0][i]) {
                    goto found;
                }
            }
            prefix += strs[0][i];
        }
    found:
        return prefix;
    }
};

int main() {
    vector<string> strs = { "flower", "flow", "flight" };

    Solution solution;
    cout << solution.longestCommonPrefix(strs) << endl;
    return 0;
}