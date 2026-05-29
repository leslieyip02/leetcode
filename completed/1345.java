class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> numberIndices = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            numberIndices.computeIfAbsent(arr[i], _ -> new ArrayList<>());
            numberIndices.get(arr[i]).add(i);
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> frontier = new ArrayDeque<>();
        frontier.add(0);
        visited.add(0);

        int steps = 0;
        while (!frontier.isEmpty()) {
            int count = frontier.size();
            for (int i = 0; i < count; i++) {
                int current = frontier.poll();
                if (current == arr.length - 1) {
                    return steps;
                }

                if (current < arr.length - 1 && !visited.contains(current + 1)) {
                    frontier.add(current + 1);
                    visited.add(current + 1);
                }
                if (current > 0 && !visited.contains(current - 1)) {
                    frontier.add(current - 1);
                    visited.add(current - 1);
                }

                List<Integer> otherIndices = numberIndices.get(arr[current]);
                if (otherIndices == null) {
                    continue;
                }
                for (int index : otherIndices) {
                    if (!visited.contains(index)) {
                        frontier.add(index);
                        visited.add(index);
                    }
                }

                // prevent redundant searches
                numberIndices.get(arr[current]).clear();
            }
            steps++;
        }
        return 0;
    }
}
