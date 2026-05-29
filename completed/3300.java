class Solution {
    public int minElement(int[] nums) {
        int min = 37;
        for (int num : nums) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            min = Math.min(sum, min);
        }
        return min;
    }
}
