import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        // deduplicate
        SortedSet<Integer> unique = new TreeSet<>();
        for (int num : nums) {
            unique.add(num);
        }

        Integer[] sorted = unique.toArray(new Integer[0]);
        int k = nums.length - sorted.length;
        int minimumCost = sorted.length - 1;
        for (int i = 0; i < sorted.length - 1; i++) {
            // assume current index is the start
            // search for the value that will end the array
            int end = sorted[i] + (nums.length - 1);
            int left = i;
            int right = sorted.length - 1;
            int index = (left + right) / 2;
            while (left <= right) {
                if (sorted[index] == end) {
                    break;
                } else if (sorted[index] < end) {
                    left = index + 1;
                } else {
                    right = index - 1;
                }
                index = (left + right) / 2;
            }

            // additional consecutive numbers needed to reach the end
            int cost = sorted.length - 1 - (index - i);
            minimumCost = Math.min(cost, minimumCost);
        }
        return minimumCost + k;
    }

    public static void main(String[] args) {
        // int[] nums = { 1, 2, 3, 5, 6 };
        // int[] nums = { 1, 10, 100, 1000 };
        int[] nums = { 8, 5, 9, 9, 8, 4 };

        Solution solution = new Solution();
        System.out.println(solution.minOperations(nums));
    }
}
