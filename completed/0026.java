class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int k = 0;
        for (int num : nums) {
            if (seen.contains(num)) {
                continue;
            }

            seen.add(num);
            nums[k] = num;
            k++;
        }
        return k;
    }
}
