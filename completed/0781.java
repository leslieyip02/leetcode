class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int answer : answers) {
            counts.put(answer, counts.getOrDefault(answer, 0) + 1);
        }

        int total = 0;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int same = entry.getKey() + 1;
            int count = entry.getValue();
            total += Math.ceil((double) count / same) * same;
        }
        return total;
    }
}
