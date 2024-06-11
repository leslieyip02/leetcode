#include <algorithm>
#include <map>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> relativeSortArray(vector<int>& arr1, vector<int>& arr2) {
        map<int, int> lookup;
        for (int i = 0; i < arr2.size(); i++) {
            lookup[arr2[i]] = i;
        }

        sort(arr1.begin(), arr1.end(), [&lookup](const int& a, const int&b) {
            int x = lookup.find(a) == lookup.end() ? 10000 + a : lookup[a];
            int y = lookup.find(b) == lookup.end() ? 10000 + b : lookup[b];
            return x < y;
        });
        return arr1;
    }
};
