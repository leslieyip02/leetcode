class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> minX = new HashMap<>();
        Map<Integer, Integer> minY = new HashMap<>();
        Map<Integer, Integer> maxX = new HashMap<>();
        Map<Integer, Integer> maxY = new HashMap<>();
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            minX.put(x, Math.min(minX.getOrDefault(x, y), y));
            minY.put(y, Math.min(minY.getOrDefault(y, x), x));
            maxX.put(x, Math.max(maxX.getOrDefault(x, y), y));
            maxY.put(y, Math.max(maxY.getOrDefault(y, x), x));
        }

        int count = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (minX.get(x) != y && minY.get(y) != x && maxX.get(x) != y && maxY.get(y) != x) {
                count++;
            }
        }
        return count;
    }
}
