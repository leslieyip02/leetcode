class Solution {
    public long findTheArrayConcVal(int[] nums) {
        long value = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left + 1 > right) {
                value += nums[left];
                break;
            }
            value += Integer.parseInt(String.format("%d%d", nums[left], nums[right]));
            left++;
            right--;
        }
        return value;
    }
}
