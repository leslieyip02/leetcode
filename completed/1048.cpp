#include <iostream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

class Solution {
public:
    int longestStrChain(vector<string>& words) {
        map<string, int> chains;
        for (auto word : words) {
            chains[word] = 1;
        }

        int k = 1;
        sort(words.begin(), words.end(), [](const auto &lhs, const auto &rhs) {
            return lhs.length() < rhs.length();
        });
        for (auto word : words) {
            for (int i = 0; i < word.length(); i++) {
                string shortened = word;
                shortened.erase(i, 1);
                auto itr = chains.find(shortened);
                if (itr != chains.end()) {
                    chains[word] = max(itr->second + 1, chains[word]);
                    k = max(chains[word], k);
                }
            }
        }
        return k;
    }
};

int main() {
    vector<string> words = { "a", "b", "ba", "bca", "bda", "bdca" };

    Solution solution;
    cout << solution.longestStrChain(words) << endl;

    words = { "abcd", "dbqca" };
    cout << solution.longestStrChain(words) << endl;
    return 0;
}
