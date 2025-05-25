class Solution {
public:
    int longestPalindrome(vector<string>& words) {
        unordered_map<string, int> ascending;
        unordered_map<string, int> descending;
        unordered_map<string, int> same;
        for (string &word : words) {
            if (word[0] == word[1]) {
                same[word]++;
                continue;
            }

            if (word[0] < word[1]) {
                ascending[word]++;
            } else {
                string key { word[1], word[0] };
                descending[key]++;
            }
        }

        int length = 0;
        for (auto const &[key, count] : ascending) {
            auto itr = descending.find(key);
            if (itr == descending.end()) {
                continue;
            }
            length += min(count, itr->second) * 4;
        }

        bool single = false;
        for (auto const &[key, count] : same) {
            if (count % 2 == 1) {
                single = true;
                length += (count - 1) * 2;
            } else {
                length += count * 2;
            }
        }
        if (single) length += 2;
        return length;
    }
};
