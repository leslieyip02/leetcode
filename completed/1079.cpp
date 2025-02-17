#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    set<string> sequences;

    void dfs(string current, map<char, int>& counts) {
        for (auto const& [letter, count] : counts) {
            if (count == 0) {
                continue;
            }

            counts[letter]--;
            current.push_back(letter);
            sequences.insert(current);
            dfs(current, counts);
            counts[letter]++;
            current.pop_back();
        }
    }

public:
    int numTilePossibilities(string tiles) {
        map<char, int> counts;
        for (char tile : tiles) {
            counts[tile]++;
        }
        dfs("", counts);
        return sequences.size();
    }
};
