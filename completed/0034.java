class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] { -1, -1 };
        }

        int left = 0;
        int right = nums.length - 1;
        int index = (left + right) / 2;
        while (nums[index] != target && left < right) {
            if (nums[index] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
            index = (left + right) / 2;
        }
        if (nums[index] != target) {
            return new int[] { -1, -1 };
        }

        while (nums[left] < target && left < index) {
            left = (left + 1 + index) / 2;
        }
        while (left > 0 && nums[left - 1] >= target) {
            left--;
        }

        while (nums[right] > target && right > index) {
            right = (right - 1 + index) / 2;
        }
        while (right < nums.length - 1 && nums[right + 1] <= target) {
            right++;
        }

        return new int[] { left, right };
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        Solution solution = new Solution();
        var result = solution.searchRange(nums, target);
        System.out.println(String.format("%d %d", result[0], result[1]));
    }
}
