class Solution {
    private static final int NOT_FOUND = -1;

    public int search(int[] nums, int target) {
        int maximumIndex = findMaximumIndex(nums);
        int leftResult = findInRange(0, maximumIndex + 1, nums, target);
        if (leftResult != NOT_FOUND) {
            return leftResult;
        }
        return findInRange(maximumIndex + 1, nums.length, nums, target);
    }

    private int findMaximumIndex(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            boolean leftOk = mid == 0 || nums[mid] > nums[mid - 1];
            boolean rightOk = mid == nums.length - 1 || nums[mid] > nums[mid + 1];
            if (leftOk && rightOk) {
                return mid;
            }

            if (nums[mid] > nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        throw new IllegalStateException();
    }

    // end is exclusive
    private int findInRange(int start, int end, int[] nums, int target) {
        if (start >= nums.length || target < nums[start] || target > nums[end - 1]) {
            return NOT_FOUND;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return NOT_FOUND;
    }
}
