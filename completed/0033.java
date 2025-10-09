class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int pivot = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid < nums.length - 1) {
                if (nums[mid + 1] < nums[mid]) {
                    pivot = mid;
                    break;
                }
            }

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid;
            }
        }

        int leftRange = searchInRange(nums, target, 0, pivot);
        if (leftRange != -1) {
            return leftRange;
        }
        int rightRange = searchInRange(nums, target, pivot + 1, nums.length - 1);
        if (rightRange != -1) {
            return rightRange;
        }
        return -1;
    }

    int searchInRange(int[] nums, int target, int left, int right) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left < nums.length && nums[left] == target ? left : -1;
    }
}
