class Solution {
private:
    bool isPalindrome(string s) {
        for (int i = 0; i < s.length() / 2; i++) {
            if (s[i] != s[s.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    long long convert(string baseK, int k) {
        long long multiplier = 1;
        long long base10 = 0;
        for (int i = baseK.length() - 1; i >= 0; i--) {
            base10 += ((int) baseK[i] - '0') * multiplier;
            multiplier *= k;
        }
        return base10;
    }

    void generate(string buffer, int current, int k, int length, vector<string>& generated) {
        int start = current == 0 ? 1 : 0;
        if (current == length / 2) {
            if (length % 2 == 0) {
                generated.push_back(buffer);
            } else {
                for (int i = start; i < k; i++) {
                    buffer[current] = (char) i + '0';
                    generated.push_back(buffer);
                }
            }
            return;
        }

        for (int i = start; i < k; i++) {
            buffer[current] = buffer[length - 1 - current] = (char) i + '0';
            generate(buffer, current + 1, k, length, generated);
        }
    }

public:
    long long kMirror(int k, int n) {
        long long sum = 0;

        int length = 1;
        while (n > 0) {
            vector<string> candidates; 
            string buffer(length, '0');
            generate(buffer, 0, k, length, candidates);

            for (string candidate : candidates) {
                long long converted = convert(candidate, k);
                if (isPalindrome(to_string(converted))) {
                    sum += converted;
                    if (--n == 0) {
                        break;
                    }
                }
            }
            length++;
        }
        return sum;
    }
};
