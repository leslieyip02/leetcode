class Solution {
public:
    int maxDiff(int num) {
        string a = to_string(num);
        char x = 'x';
        for (int i = 0; i < a.length(); i++) {
            if (a[i] != '9') {
                x = a[i];
                break;
            }
        }
        if (x != 'x') {
            replace(a.begin(), a.end(), x, '9');
        }

        string b = to_string(num);
        x = 'x';
        if (b[0] == '1') {
            for (int i = 1; i < b.length(); i++) {
                if (b[i] != '0' && b[i] != '1') {
                    x = b[i];
                    break;
                }
            }
            if (x != 'x') {
                replace(b.begin(), b.end(), x, '0');
            }
        } else {
            x = b[0];
            replace(b.begin(), b.end(), x, '1');
        }

        return stoi(a) - stoi(b);
    }
};
