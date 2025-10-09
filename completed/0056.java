class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<Integer[]> current = new ArrayList<>();
        for (int[] interval : intervals) {
            if (current.isEmpty()) {
                current.add(new Integer[]{ interval[0], interval[1] });
                continue;
            }

            Integer[] last = current.get(current.size() - 1);
            if (interval[0] > last[1]) {
                current.add(new Integer[]{ interval[0], interval[1] });
                continue;
            }
            last[1] = Math.max(interval[1], last[1]);
        }

        int[][] merged = new int[current.size()][2];
        for (int i = 0; i < current.size(); i++) {
            merged[i][0] = current.get(i)[0];
            merged[i][1] = current.get(i)[1];
        }
        return merged;
    }
}
