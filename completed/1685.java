class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] += nums[i] * (i + 1) - sums[i];
            output[i] += (sums[nums.length - 1] - sums[i]) - (nums[i] * (nums.length - i - 1));
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5 };

        Solution solution = new Solution();
        var result = solution.getSumAbsoluteDifferences(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
