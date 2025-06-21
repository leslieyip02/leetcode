class Solution {
public:
    int minimumDeletions(string word, int k) {
        vector<int> frequencies(26, 0);
        for (char c : word) {
            frequencies[(int) (c - 'a')]++;
        }
        sort(frequencies.begin(), frequencies.end());

        int deletions = word.length();
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (frequencies[i] == 0) {
                continue;
            }

            int right = i;
            while (right < 26) {
                if (frequencies[right] - frequencies[i] > k) {
                    break;
                }
                right++;
            }

            int current = sum;
            for (int j = right; j < 26; j++) {
                current += frequencies[j] - frequencies[i] - k;
            }
            deletions = min(current, deletions);
            sum += frequencies[i];
        }
        return deletions;
    }
};
