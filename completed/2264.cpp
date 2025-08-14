class Solution {
public:
    string largestGoodInteger(string num) {
        int largest = -1;
        int left = 0;
        while (left < num.length()) {
            int right = left + 1;
            while (right < num.length() && num[right] == num[left]) {
                right++;
            }

            if (right - left >= 3) {
                largest = max((int) num[left] - '0', largest);
            }
            left = right;
        }

        if (largest == -1) {
            return "";
        }

        return string(3, (char) largest + '0');
    }
};
