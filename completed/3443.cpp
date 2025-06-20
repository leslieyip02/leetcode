class Solution {
private:
    int distance(string s) {
        int x = 0;
        int y = 0;
        int d = 0;
        for (char c : s) {
            if (c == 'N') y++;
            if (c == 'S') y--;
            if (c == 'E') x++;
            if (c == 'W') x--;
            d = max(abs(x) + abs(y), d);
        }
        return d;
    }

    string replace(string s, vector<char> from, vector<char> to, int k) {
        string t = s;
        if (k == 0) {
            return t;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < from.size(); j++) {
                if (t[i] == from[j]) {
                    t[i] = to[j];
                    k--;
                    if (k == 0) {
                        return t;
                    }
                }
            }
        }
        return t;
    }

public:
    int maxDistance(string s, int k) {
        int ne = distance(replace(s, { 'S', 'W' }, { 'N', 'E' }, k));
        int nw = distance(replace(s, { 'S', 'E' }, { 'N', 'W' }, k));
        int se = distance(replace(s, { 'N', 'W' }, { 'S', 'E' }, k));
        int sw = distance(replace(s, { 'N', 'E' }, { 'S', 'W' }, k));
        return max(ne, max(nw, max(se, sw)));
    }
};
