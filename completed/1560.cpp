#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> mostVisited(int n, vector<int>& rounds) {
        vector<int> v(n, 0);
        for (int i = 1; i < rounds.size(); i++) {
            int j = rounds[i - 1] - 1;
            while (j != rounds[i] - 1) {
                v[j]++;
                j = (j + 1) % n;
            }
        }
        v[rounds.back() - 1]++;

        int m = v[0];
        vector<int> s = { 1 };
        for (int i = 1; i < n; i++) {
            if (v[i] > m) {
                m = v[i];
                s = { i + 1 };
            } else if (v[i] == m) {
                s.push_back(i + 1);
            }
        }
        return s;
    }
};

int main() {
    // int n = 4;
    // vector<int> rounds = { 1, 3, 1, 2 };
    // int n = 2;
    // vector<int> rounds = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
    // int n = 7;
    // vector<int> rounds = { 1, 3, 5, 7, 2 };
    int n = 3;
    vector<int> rounds = { 2, 1, 2, 1, 3, 2, 3, 1, 2, 3, 1, 3, 1, 2, 3, 1, 3, 2, 3, 2, 1, 2, 3, 1, 3 };

    Solution solution;
    auto results = solution.mostVisited(n, rounds);
    for (auto i : results) {
        cout << i << " ";
    }
    cout << endl;
    return 0;
}