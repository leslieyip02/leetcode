class Solution {
private:
    string next(string word) {
        string result = word;
        for (char c : word) {
            result += (char) ((c - 'a' + 1) % 26) + 'a';
        }
        return result;
    }

public:
    char kthCharacter(int k) {
        string word = "a";
        while (word.length() < k) {
            word = next(word);
        }
        return word[k - 1];
    }
};
