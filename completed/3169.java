class Solution {
    public int countDays(int days, int[][] meetings) {
        PriorityQueue<Pair<Integer, Integer>> remaining = new PriorityQueue<>((a, b) -> a.getKey() - b.getKey());
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            remaining.add(new Pair(start, 1));
            remaining.add(new Pair(end, -1));
        }

        int sum = 0;
        int count = 0;
        int previousIndex = 0;
        while (!remaining.isEmpty()) {
            Pair<Integer, Integer> current = remaining.poll();
            if (sum == 0) {
                count += Math.max(current.getKey() - 1 - previousIndex, 0);
            }

            sum += current.getValue();
            previousIndex = current.getKey();
        }
        count += days - previousIndex;
        return count;
    }
}
