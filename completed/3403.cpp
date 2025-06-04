class Solution {
public:
    string answerString(string word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }

        int n = word.length() - numFriends + 1;
        string largest = "";
        for (int i = 0; i < word.length(); i++) {
            string substring = word.substr(i, n);
            if (substring > largest) {
                largest = substring;
            }
        }
        return largest;
    }
};
