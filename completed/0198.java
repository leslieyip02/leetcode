class Solution {
    public int rob(int[] nums) {
        int previous = 0;
        int current = 0;
        for (int num : nums) {
            int rob = previous + num;
            int tmp = current;
            current = Math.max(rob, current);
            previous = tmp;
        }
        return current;
    }
}
