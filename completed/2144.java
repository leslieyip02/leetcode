class Solution {
    public int minimumCost(int[] cost) {
        List<Integer> sorted = Arrays.stream(cost)
            .sorted()
            .boxed()
            .toList();

        int total = 0;
        for (int i = 1; i <= sorted.size(); i++) {
            if (i % 3 == 0) {
                continue;
            }
            total += sorted.get(sorted.size() - i);
        }
        return total;
    }
}
