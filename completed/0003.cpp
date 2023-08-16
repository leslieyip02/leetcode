#include <iostream>
#include <unordered_set>
using namespace std;

class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> c;

        int i = 0;
        int j = 0;
        int m = 0;
        while (j < s.length())
        {
            while (c.find(s[j]) != c.end())
            {
                c.erase(s[i]);
                i++;
            }
            c.insert(s[j]);
            int l = j - i + 1;
            if (l > m)
            {
                m = l;
            }
            j++;
        }
        return m;
    }
};

int main()
{
    string s = "pwwkew";

    Solution solution;
    cout << solution.lengthOfLongestSubstring(s) << endl;
    return 0;
}
