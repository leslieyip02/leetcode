#include <iostream>
#include <utility>
#include <algorithm>
using namespace std;

class Solution {
public:
    string reorganizeString(string s) {
        pair<char, int> counts[26];
        for (int i = 0; i < 26; i++) {
            counts[i] = { (char) (i + 97), 0 };
        }

        for (char c : s) {
            counts[c - 97].second++;
        }


        string result = "";
        for (int i = 0; i < s.length(); i++) {
            sort(counts, counts + sizeof(counts) / sizeof(counts[0]),
            [](const auto& p1, const auto& p2) {
                return p1.second > p2.second;
            });

            int j = 0;
            if (!result.empty() && counts[0].first == result.back()) {
                j++;
            }
            if (counts[j].second == 0) {
                return "";
            }
            result += counts[j].first;
            counts[j].second--;
        }
        return result;
    }
};

int main() {
    string s = "aab";

    Solution solution;
    cout << solution.reorganizeString(s) << endl;
    cout << solution.reorganizeString("aaab") << endl;
    cout << solution.reorganizeString("ccbbaaccb") << endl;
    return 0;
}