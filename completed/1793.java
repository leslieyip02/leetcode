import java.util.*;

class Solution {
    public int maximumScore(int[] nums, int k) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(left, -1);
        Arrays.fill(right, nums.length);

        Stack<Integer> indices = new Stack<>();
        for (int i = nums.length - 1; i > -1; i--) {
            // set index of previous elements which are smaller
            while (!indices.isEmpty() && nums[i] < nums[indices.peek()]) {
                left[indices.pop()] = i;
            }
            indices.push(i);
        }

        indices.clear();
        for (int i = 0; i < nums.length; i++) {
            // set index of previous elements which are smaller
            while (!indices.isEmpty() && nums[i] < nums[indices.peek()]) {
                right[indices.pop()] = i;
            }
            indices.push(i);
        }

        int score = 0;
        for (int i = 0; i < nums.length; i++) {
            if (left[i] < k && right[i] > k) {
                score = Math.max(nums[i] * (right[i] - left[i] - 1), score);
            }
        }
        return score;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 3, 7, 4, 5 };
        int k = 3;
        // int[] nums = { 5, 5, 4, 5, 1, 1, 1 };
        // int k = 0;

        Solution solution = new Solution();
        System.out.println(solution.maximumScore(nums, k));
    }
}
