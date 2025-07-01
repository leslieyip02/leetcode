class Solution {
public:
    int possibleStringCount(string word) {
        int left = 0;
        int possible = 1;
        while (left < word.length()) {
            int right = left + 1;
            while (right < word.length() && word[right] == word[left]) {
                right++;
            }
            possible += (right - left - 1);
            left = right;
        }
        return possible;
    }
};
