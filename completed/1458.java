class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int min1 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int n : nums1) {
            min1 = Math.min(n, min1);
            max1 = Math.max(n, max1);
        }
        for (int n : nums2) {
            min2 = Math.min(n, min2);
            max2 = Math.max(n, max2);
        }
        // check special case
        if ((min1 > 0 && max2 < 0) || (max1 < 0 && min2 > 0)) {
            return Math.max(min1 * max2, max1 * min2);
        }

        for (int i = nums1.length - 1; i>= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                int p = nums1[i] * nums2[j] + dp[i + 1][j + 1];
                int q = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(p, q);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        // int[] nums1 = { 2, 1, -2, 5 };
        // int[] nums2 = { 3, 0, -6 };
        // int[] nums1 = { 3, -2 };
        // int[] nums2 = { 2, -6, 7 };
        // int[] nums1 = { -5, -1, -2 };
        // int[] nums2 = { 3, 3, 5, 5 };
        int[] nums1 = { 5, -4, -3 };
        int[] nums2 = { -4, -3, 0, -4, 2 };

        Solution solution = new Solution();
        System.out.println(solution.maxDotProduct(nums1, nums2));
    }
}
