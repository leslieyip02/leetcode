class Solution {
private:
    int getLength(int n) {
        int length = 0;
        while (n > 0) {
            length++;
            n /= 10;
        }
        return length;
    }

public:
    bool reorderedPowerOf2(int n) {
        vector<int> options;
        int current = 1;
        int currentLength = 1;
        int targetLength = getLength(n);
        while (currentLength <= targetLength) {
            if (currentLength == targetLength) {
                options.push_back(current);
            }

            if (current == (1 << 31)) {
                break;
            }

            current <<= 1;
            currentLength = getLength(current);
        }

        int availableDigits[10] = { 0 };
        while (n > 0) {
            availableDigits[n % 10]++;
            n /= 10;
        }

        for (int option : options) {
            int optionDigits[10] = { 0 };
            while (option > 0) {
                optionDigits[option % 10]++;
                option /= 10;
            }

            bool ok = true;
            for (int i = 0; i < 10; i++) {
                if (optionDigits[i] != availableDigits[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return true;
            }
        }
        return false;
    }
};
