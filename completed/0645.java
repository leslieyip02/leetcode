class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] ok = new int[n];
        int duped = -1;
        for (int num : nums) {
            if (ok[num - 1] != 0) {
                duped = num;
            }
            ok[num - 1] = num;
        }
        int missing = -1;
        for (int i = 0; i < n; i++) {
            if (ok[i] == 0) {
                missing = i + 1;
                break;
            }
        }
        return new int[] { duped, missing };
    }
}
