class Solution {
private:
    long long productsLessThan(
        long long k,
        long long num1,
        vector<int>& nums2
    ) {
        int left = 0;
        int right = nums2.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long long product = num1 * nums2[mid];
            if (num1 >= 0) {
                if (product <= k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (product > k) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return num1 >= 0 ? left : nums2.size() - left;
    }

public:
    long long kthSmallestProduct(
        vector<int>& nums1,
        vector<int>& nums2,
        long long k
    ) {
        long long left = -1e10;
        long long right = 1e10;
        while (left <= right) {
            long long mid = (left + right) / 2;
            long long count = 0;
            for (int num1 : nums1) {
                count += productsLessThan(mid, num1, nums2);
            }

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
};
