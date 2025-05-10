class Solution {
public:
    long long minSum(vector<int>& nums1, vector<int>& nums2) {
        long long sum1 = 0;      
        int zeroes1 = 0;
        for (int num : nums1) {
            sum1 += num;
            if (num == 0) {
                zeroes1++;
            }
        }
        long long sum2 = 0;      
        int zeroes2 = 0;
        for (int num : nums2) {
            sum2 += num;
            if (num == 0) {
                zeroes2++;
            }
        }

        if (zeroes1 == 0 && zeroes2 == 0) {
            return sum1 == sum2 ? sum1 : -1;
        }

        if (zeroes1 == 0) {
            return sum1 - sum2 >= zeroes2 ? sum1 : -1;
        }
        if (zeroes2 == 0) {
            return sum2 - sum1 >= zeroes1 ? sum2 : -1;
        }

        return max(sum1 + zeroes1, sum2 + zeroes2);
    }
};
