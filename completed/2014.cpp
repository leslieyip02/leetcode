class Solution {
private:
    bool satisfies(string candidate, string s, int k) {
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s[i] != candidate[index]) {
                continue;
            }

            index++;
            if (index == candidate.length()) {
                if (--k == 0) return true;
                index = 0;
            }
        }
        return false;
    }

public:
    string longestSubsequenceRepeatedK(string s, int k) {
        vector<int> counts(26, 0);
        for (int i = 0; i < s.length(); i++) {
            counts[(int) s[i] - 'a']++;
        }

        vector<string> candidates;
        for (int i = 25; i >= 0; i--) {
            if (counts[i] >= k) {
                candidates.push_back(string(1, (char) i + 'a'));
            }
        }

        string longest = "";
        queue<string> queue(candidates.begin(), candidates.end());
        while (!queue.empty()) {
            string current = queue.front();
            queue.pop();

            if (current.length() > longest.length()) {
                longest = current;
            }

            for (string candidate : candidates) {
                string next = current + candidate;
                if (satisfies(next, s, k)) {
                    queue.push(next);
                }
            }
        }
        return longest;
    }
};
