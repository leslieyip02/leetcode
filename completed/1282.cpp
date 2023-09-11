#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<vector<int>> groupThePeople(vector<int>& groupSizes) {
        map<int, vector<int>> groups;
        vector<vector<int>> results;
        for (int i = 0; i < groupSizes.size(); i++) {
            if (groups.find(groupSizes[i]) == groups.end()) {
                groups[groupSizes[i]] = vector<int>();
            }
            groups[groupSizes[i]].push_back(i);
            if (groups[groupSizes[i]].size() == groupSizes[i]) {
                results.push_back(groups[groupSizes[i]]);
                groups.erase(groupSizes[i]);
            }
        }
        return results;
    }
};

int main() {
    // vector<int> groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
    vector<int> groupSizes = { 2, 1, 3, 3, 3, 2 };

    Solution solution;
    auto results = solution.groupThePeople(groupSizes);
    for (auto result : results) {
        for (auto i : result) {
            cout << i << " ";
        }
        cout << endl;
    }
    return 0;
}
