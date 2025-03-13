class Solution {
    private boolean ok(int[] nums, int[][] queries, int k) {
        int[] diffs = new int[nums.length + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            diffs[l] += val;
            diffs[r + 1] -= val;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diffs[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        if (!ok(nums, queries, queries.length)) {
            return -1;
        }

        int lower = 0;
        int upper = queries.length;
        while (lower < upper) {
            int mid = (lower + upper) / 2;
            if (ok(nums, queries, mid)) {
                upper = mid;
            } else {
                lower = mid + 1;
            }
        }
        return lower;
    }
}
