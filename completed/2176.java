class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }

        int pairs = 0;
        for (List<Integer> values : indices.values()) {
            for (int i = 0; i < values.size(); i++) {
                for (int j = i + 1; j < values.size(); j++) {
                    if ((values.get(i) * values.get(j)) % k == 0) {
                        pairs++;
                    }
                }
            }
        }
        return pairs;
    }
}
