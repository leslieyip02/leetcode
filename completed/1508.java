import java.util.*;

class Solution {
    private static final int M = (int) 1e9 + 7;

    private void add(int sum, TreeMap<Integer, Integer> sums) {
        sums.put(sum, sums.getOrDefault(sum, 0) + 1);
    }

    public int rangeSum(int[] nums, int n, int left, int right) {
        TreeMap<Integer, Integer> sums = new TreeMap<>();

        int[] prefixes = new int[n];
        prefixes[0] = nums[0];
        add(prefixes[0], sums);
        for (int i = 1; i < n; i++) {
            prefixes[i] = prefixes[i - 1] + nums[i];
            add(prefixes[i], sums);
        }

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                add(prefixes[i] - prefixes[j], sums);
            }
        }

        for (int i = 1; i < left; i++) {
            Map.Entry<Integer, Integer> entry = sums.firstEntry();
            if (entry.getValue() == 1) {
                sums.pollFirstEntry();
            } else {
                sums.put(entry.getKey(), entry.getValue() - 1);
            }
        }

        int sum = 0;
        for (int i = 0; i <= right - left; i++) {
            Map.Entry<Integer, Integer> entry = sums.firstEntry();
            sum = (sum + entry.getKey()) % M;
            if (entry.getValue() == 1) {
                sums.pollFirstEntry();
            } else {
                sums.put(entry.getKey(), entry.getValue() - 1);
            }
        }
        return sum;
    }
}
