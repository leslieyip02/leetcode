class Solution {
    public int[] sumZero(int n) {
        int[] nums = new int[n];
        if (n % 2 == 1) {
            nums[n - 1] = 0;
            n--;
        }
        for (int i = 0; i < n; i++) {
            nums[i] = (i / 2 + 1) * (i % 2 == 0 ? 1 : -1);
        }
        return nums;
    }
}
