class Solution {
public:
    int maximumLength(vector<int>& nums) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        int oddAlternate = 0;
        bool expectOdd = true;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                if (!expectOdd) {
                    oddAlternate++;
                    expectOdd = true;
                }
            } else {
                if (expectOdd) {
                    oddAlternate++;
                    expectOdd = false;
                }
            }
        }

        int evenAlternate = 0;
        bool expectEven = true;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] % 2 == 0) {
                if (expectEven) {
                    evenAlternate++;
                    expectEven = false;
                }
            } else {
                if (!expectEven) {
                    evenAlternate++;
                    expectEven = true;
                }
            }
        }

        return max(odd, max(even, max(oddAlternate, evenAlternate)));
    }
};
