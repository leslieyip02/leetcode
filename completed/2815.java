class Solution {
    public int maxSum(int[] nums) {
        int[][] digits = new int[10][2];
        for (int n : nums) {
            int i = 0;
            int m = n;
            while (m > 0) {
                i = Math.max(m % 10, i);
                m /= 10;
            }
            if (n > digits[i][0]) {
                digits[i][1] = digits[i][0];
                digits[i][0] = n;
            } else if (n > digits[i][1]) {
                digits[i][1] = n;
            }
        }
        int s = -1;
        for (int i = 1; i < 10; i++) {
            if (digits[i][0] != 0 && digits[i][1] != 0) {
                s = Math.max(digits[i][0] + digits[i][1], s);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] nums = { 51, 71, 17, 24, 42 };

        Solution solution = new Solution();
        System.out.println(solution.maxSum(nums));
    }
}
