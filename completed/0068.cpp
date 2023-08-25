#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

class Solution {
public:
    vector<string> fullJustify(vector<string>& words, int maxWidth) {
        int current = 0;
        vector<string> line;
        vector<string> lines;
        for (auto word : words) {
            if (line.size() + current + word.length() > maxWidth) {
                int diff = maxWidth - current;
                string justified = "";
                for (int i = 0; i < line.size() - 1; i++) {
                    justified += line[i];
                    int spaces = ceil(diff / (line.size() - 1.0 - i));
                    diff -= spaces;
                    justified += string(spaces, ' ');
                }
                justified += line.back();
                justified += string(maxWidth - justified.size(), ' ');
                lines.push_back(justified);
                line.clear();
                current = 0;
            }
            line.push_back(word);
            current += word.length();
        }
        string lastLine = "";
        for (int i = 0; i < line.size() - 1; i++) {
            lastLine += line[i] + " ";
        }
        lastLine += line.back();
        lastLine += string(maxWidth - lastLine.size(), ' ');
        lines.push_back(lastLine);
        return lines;
    }
};

int main() {
    // vector<string> words = { "This", "is", "an", "example", "of", "text", "justification." };
    // int maxWidth = 16;
    vector<string> words = { "What", "must", "be", "acknowledgment", "shall", "be" };
    int maxWidth = 16;
    // vector<string> words = { "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" };
    // int maxWidth = 20;

    Solution solution;
    auto results = solution.fullJustify(words, maxWidth);
    for (auto line : results) {
        cout << line << endl;
    }
    return 0;
}