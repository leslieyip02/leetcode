class Solution {

    private static final int M = (int) 1e9 + 7;

    public int countTrapezoids(int[][] points) {
        Map<Integer, Set<Integer>> uniqueXGroupedByY = new HashMap<>();
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            Set<Integer> uniqueX = uniqueXGroupedByY.computeIfAbsent(y, _ -> new HashSet<>());
            uniqueX.add(x);
        }

        List<Integer> horizontalCounts = new ArrayList<>();
        for (Set<Integer> uniqueX : uniqueXGroupedByY.values()) {
            if (uniqueX.size() < 2) {
                continue;
            }
            horizontalCounts.add((int) ((long) uniqueX.size() * (uniqueX.size() - 1) / 2) % M);
        }

        long[] prefixSums = new long[horizontalCounts.size() + 1];
        for (int i = 0; i < horizontalCounts.size(); i++) {
            prefixSums[i + 1] = horizontalCounts.get(i) + prefixSums[i];
            prefixSums[i + 1] %= M;
        }

        long count = 0;
        for (int i = 0; i < horizontalCounts.size(); i++) {
            count += (horizontalCounts.get(i) * (prefixSums[horizontalCounts.size()] - prefixSums[i + 1])) % M;
            count %= M;
        }
        return (int) count;
    }
}
