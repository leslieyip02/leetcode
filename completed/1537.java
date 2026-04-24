class Solution {
    private static int M = (int) (1e9 + 7);

    public int maxSum(int[] nums1, int[] nums2) {
        long result = 0;
        long sum1 = 0;
        long sum2 = 0;
        int i1 = 0;
        int i2 = 0;
        while (i1 < nums1.length || i2 < nums2.length) {
            if (i2 == nums2.length || (i1 < nums1.length && nums1[i1] < nums2[i2])) {
                sum1 += nums1[i1];
                i1++;
            } else if (i1 == nums1.length || (i2 < nums2.length && nums2[i2] < nums1[i1])) {
                sum2 += nums2[i2];
                i2++;
            } else if (nums1[i1] == nums2[i2]) {
                result += nums1[i1] + Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                i1++;
                i2++;
            }
        }
        result += Math.max(sum1, sum2);
        result %= M;
        return (int) result;
    }
}
