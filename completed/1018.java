class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> results = new ArrayList<>();
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            current <<= 1;
            if (nums[i] == 1) {
                current += 1;
            }
            results.add(current % 5 == 0);
            current %= 5;
        }
        return results;
    }
}
