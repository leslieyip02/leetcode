class Solution {
private:
    bool isvowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

public:
    bool isValid(string word) {
        if (word.length() < 3) {
            return false;
        }

        bool hasVowel = false;
        bool hasConsonant = false;
        for (int i = 0; i < word.length(); i++) {
            char c = word[i];
            if (!isalpha(c) && !isdigit(c)) {
                return false;
            }

            if (isvowel(tolower(c))) {
                hasVowel = true;
            } else if (!isdigit(c)) {
                hasConsonant = true;
            }
        }
        return hasVowel && hasConsonant;
    }
};
