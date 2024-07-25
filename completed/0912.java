class Solution {
    private int[] helper(int[] nums, int start, int end) {
        if (end - start == 1) {
            return new int[]{ nums[start] };
        }

        int mid = (start + end) / 2;
        int[] left = helper(nums, start, mid);
        int[] right = helper(nums, mid, end);
        int leftIndex = 0;
        int rightIndex = 0;
        int[] ordered = new int[end - start];
        for (int i = 0; i < ordered.length; i++) {
            if (leftIndex < left.length) {
                if (rightIndex < right.length && right[rightIndex] < left[leftIndex]) {
                    ordered[i] = right[rightIndex];
                    rightIndex++;
                } else {
                    ordered[i] = left[leftIndex];
                    leftIndex++;
                }
            } else {
                ordered[i] = right[rightIndex];
                rightIndex++;
            }
        }
        return ordered;
    }

    public int[] sortArray(int[] nums) {
        return helper(nums, 0, nums.length);
    }
}
