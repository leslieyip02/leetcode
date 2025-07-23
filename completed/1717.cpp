class Solution {
public:
    int maximumGain(string s, int x, int y) {
        int score = 0;

        stack<char> forward;
        for (int i = 0; i < s.length(); i++) {
            if ((s[i] != 'a' && s[i] != 'b') || forward.empty()) {
                forward.push(s[i]);
                continue;
            }

            if (x > y) {
                if (s[i] == 'b' && forward.top() == 'a') {
                    forward.pop();
                    score += x;
                } else {
                    forward.push(s[i]);
                }
            } else {
                if (s[i] == 'a' && forward.top() == 'b') {
                    forward.pop();
                    score += y;
                } else {
                    forward.push(s[i]);
                }
            }
        }

        stack<char> backward;
        while (!forward.empty()) {
            char c = forward.top();
            forward.pop();

            if ((c != 'a' && c != 'b') || backward.empty()) {
                backward.push(c);
                continue;
            }

            if (x > y) {
                if (c == 'b' && backward.top() == 'a') {
                    backward.pop();
                    score += y;
                } else {
                    backward.push(c);
                }
            } else {
                if (c == 'a' && backward.top() == 'b') {
                    backward.pop();
                    score += x;
                } else {
                    backward.push(c);
                }
            }
        }
        return score;
    }
};
