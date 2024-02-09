import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int[] lengths = new int[n];
        int[] indices = new int[n];
        Arrays.fill(lengths, 1);
        Arrays.fill(indices, -1);
        
        int lastIndex = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && lengths[j] >= lengths[i]) {
                    lengths[i] = lengths[j] + 1;
                    indices[i] = j;
                    if (lengths[i] > lengths[lastIndex]) {
                        lastIndex = i;
                    }
                }
            }
        }

        List<Integer> subset = new ArrayList<>();
        while (lastIndex != -1) {
            subset.add(nums[lastIndex]);
            lastIndex = indices[lastIndex];
        }
        return subset;
    }
}
