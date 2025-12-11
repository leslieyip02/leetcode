class Solution {

    private static final int M = (int) 1e9 + 7;

    public int specialTriplets(int[] nums) {
        Map<Integer, Integer> rightCounts = new HashMap<>();
        for (int num : nums) {
            rightCounts.put(num, rightCounts.getOrDefault(num, 0) + 1);
        }

        long answer = 0;
        Map<Integer, Integer> leftCounts = new HashMap<>();
        for (int num : nums) {
            rightCounts.put(num, rightCounts.get(num) - 1);

            int target = num * 2;
            answer += (long) leftCounts.getOrDefault(target, 0) * rightCounts.getOrDefault(target, 0);
            answer %= M;

            leftCounts.put(num, leftCounts.getOrDefault(num, 0) + 1);
        }
        return (int) answer;
    }
}
