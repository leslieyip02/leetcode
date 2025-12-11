class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int index = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            }
            if (num < target) {
                index++;
            }
        }

        List<Integer> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            results.add(index + i);
        }
        return results;
    }
}
