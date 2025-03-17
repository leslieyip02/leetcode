class Solution {
    public boolean divideArray(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (int count : counts.values()) {
            if (count % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
