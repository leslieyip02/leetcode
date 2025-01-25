import java.util.*;

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Queue<Integer>> groups = new ArrayList<>();
        Map<Integer, Integer> groupIndices = new HashMap<>();
        Queue<Integer> group = new LinkedList<>();

        int index = 0;
        group.add(sorted[0]);
        groupIndices.put(sorted[0], index);
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i] - sorted[i - 1] > limit) {
                groups.add(group);
                group = new LinkedList<>();
                index++;
            }
            group.add(sorted[i]);
            groupIndices.put(sorted[i], index);
        }
        groups.add(group);

        int[] smallest = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            index = groupIndices.get(nums[i]);
            smallest[i] = groups.get(index).poll();
        }
        return smallest;
    }
}
