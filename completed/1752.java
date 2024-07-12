class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int start = 0;
        while (start < n) {
            boolean done = true;
            for (int i = 1; i < n; i++) {
                int current = nums[(start + i) % n];
                int previous = nums[(start + i - 1) % n];
                if (current < previous) {
                    start += i;
                    done = false;
                    break;
                }
            }
            if (done) {
                return true;
            }
        }
        return false;
    }
}
