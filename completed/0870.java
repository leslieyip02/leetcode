import java.util.*;

class Solution {
    class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair other) {
            return this.value - other.value;
        }
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        Pair[] pairs = new Pair[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums2[i], i);
        }
        Arrays.sort(pairs);

        Arrays.sort(nums1);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums1.length - 1; i >= 0; i--) {
            stack.push(nums1[i]);
        }

        int[] shuffled = new int[nums1.length];
        Arrays.fill(shuffled, -1);
        Stack<Integer> unused = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            int num = stack.pop();
            while (!stack.isEmpty() && pairs[i].value >= num) {
                unused.push(num);
                num = stack.pop();
            }

            if (pairs[i].value >= num) {
                unused.push(num);
            } else {
                shuffled[pairs[i].index] = num;
            }

            if (stack.isEmpty()) {
                break;
            }
        }
        while (!stack.isEmpty()) {
            unused.push(stack.pop());
        }
        int i = 0;
        while (!unused.isEmpty()) {
            while (shuffled[i] != -1) {
                i++;
            }
            shuffled[i] = unused.pop();
        }
        return shuffled;
    }

    public static void main(String[] args) {
        // int[] nums1 = { 2, 7, 11, 15 };
        // int[] nums2 = { 1, 10, 4, 11 };
        int[] nums1 = { 12, 24, 8, 32 };
        int[] nums2 = { 13, 25, 32, 11 };

        Solution solution = new Solution();
        int[] result = solution.advantageCount(nums1, nums2);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
