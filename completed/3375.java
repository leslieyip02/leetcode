class Solution {
    public int minOperations(int[] nums, int k) {
        SortedSet<Integer> sorted = new TreeSet<>();
        for (int num : nums) {
            sorted.add(num);
        }

        if (sorted.first() < k) {
            return -1;
        }
        int ops = sorted.size() - 1;
        if (sorted.first() > k) {
            ops++;
        }
        return ops;
    }
}
