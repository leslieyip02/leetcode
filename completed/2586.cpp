#include <bits/stdc++.h>
using namespace std;

class Solution {
private:
    bool isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

public:
    int vowelStrings(vector<string>& words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            string word = words[i];
            if (isVowel(word.front()) && isVowel(word.back())) {
                count++;
            }
        }
        return count;
    }
};
