class Solution {
private:
    int index(char c) {
        return c < 'a' ? (int) c - 'A' : (int) c - 'a';
    }

public:
    vector<string> findWords(vector<string>& words) {
        vector<string> rows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm",
        };

        vector<int> indices(26);
        for (int i = 0; i < rows.size(); i++) {
            for (char c : rows[i]) {
                indices[index(c)] = i;
            }
        }

        vector<string> results;
        for (string word : words) {
            int target = indices[index(word[0])];

            bool ok = true;
            for (char c : word) {
                if (indices[index(c)] != target) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                results.push_back(word);
            }
        }
        return results;
    }
};
