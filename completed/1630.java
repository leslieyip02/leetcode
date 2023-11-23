import java.util.*;

class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> results = new ArrayList();
        for (int i = 0; i < l.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            PriorityQueue<Integer> subArray = new PriorityQueue<>();
            for (int j = l[i]; j <= r[i]; j++) {
                subArray.add(nums[j]);
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
            }

            boolean ok = false;
            if ((max - min) % (r[i] - l[i]) == 0) {
                ok = true;
                int interval = Math.abs((max - min) / (r[i] - l[i]));
                int previous = subArray.poll();
                while (!subArray.isEmpty()) {
                    int current = subArray.poll();
                    if (current - previous != interval) {
                        ok = false;
                        break;
                    }
                    previous = current;
                }
            }
            results.add(ok);
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 5, 9, 3, 7 };
        int[] l = { 0, 0, 2 };
        int[] r = { 2, 3, 5 };

        Solution solution = new Solution();
        var results = solution.checkArithmeticSubarrays(nums, l, r);
        for (var result : results) {
            System.out.print(result + " ");
        }
        System.out.println();
    }
}
