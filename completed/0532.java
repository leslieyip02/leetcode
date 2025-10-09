class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> unique = new HashMap<>();
        for (int num : nums) {
            unique.put(num, unique.getOrDefault(num, 0) + 1);
        }

        int pairs = 0;
        if (k == 0) {
            for (Integer count : unique.values()) {
                pairs += count > 1 ? 1 : 0;
            }
        } else {
            for (Integer num : unique.keySet()) {
                if (unique.containsKey(num + k)) {
                    pairs++;
                }
            }
        }
        return pairs;
    }
}
