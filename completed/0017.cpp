#include <iostream>
#include <vector>
#include <string>
#include <cstdlib>
using namespace std;

class Solution {
private:
    vector<string> numPad[10] = {
        {},
        {},
        { "a", "b", "c" },
        { "d", "e", "f" },
        { "g", "h", "i" },
        { "j", "k", "l" },
        { "m", "n", "o" },
        { "p", "q", "r", "s" },
        { "t", "u", "v" },
        { "w", "x", "y", "z" }
    };

public:
    vector<string> letterCombinations(string digits) {
        if (digits.empty()) {
            return {};
        }

        vector<string> results = letterCombinations(digits.substr(1));
        auto alphabet = numPad[digits.front() - '0'];
        if (results.empty()) {
            return alphabet;
        }

        int n = alphabet.size();
        vector<string> combinations(results.size() * n);
        for (int i = 0; i < results.size(); i++) {
            for (int j = 0; j < n; j++) {
                combinations[i * n + j] = alphabet[j] + results[i];
            }
        }
        return combinations;
    }
};

int main() {
    // string digits = "23";
    string digits = "234";

    Solution solution;
    auto results = solution.letterCombinations(digits);
    for (string result : results) {
        cout << result << endl;
    }
    return 0;
}