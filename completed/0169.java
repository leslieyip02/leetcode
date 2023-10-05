class Solution {
    public int majorityElement(int[] nums) {
        // boyer-moore majority vote algorithm
        int m = 0;
        int c = 0;
        for (int num : nums) {
            if (c == 0) {
                m = num;
                c = 1;
            } else if (m == num) {
                c++;
            } else {
                c--;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3 };

        Solution solution = new Solution();
        System.out.println(solution.majorityElement(nums));
    }
}
