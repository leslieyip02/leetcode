class Solution {
    private void dfs(int current, boolean[] suspicious, List<List<Integer>> adjacencyLists) {
        suspicious[current] = true;
        for (int adjacent : adjacencyLists.get(current)) {
            if (suspicious[adjacent]) {
                continue;
            }
            dfs(adjacent, suspicious, adjacencyLists);
        }
    }

    private boolean invoked(int n, boolean[] suspicious, List<List<Integer>> adjacencyLists) {
        for (int i = 0; i < n; i++) {
            if (suspicious[i]) {
                continue;
            }
            for (int adjacent : adjacencyLists.get(i)) {
                if (suspicious[adjacent]) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new ArrayList<>());
        }
        for (int[] invocation : invocations) {
            int from = invocation[0];
            int to = invocation[1];
            adjacencyLists.get(from).add(to);
        }

        boolean[] suspicious = new boolean[n];
        dfs(k, suspicious, adjacencyLists);
        List<Integer> remaining = new ArrayList<>();
        boolean remove = !invoked(n, suspicious, adjacencyLists);
        for (int i = 0; i < n; i++) {
            if (remove && suspicious[i]) {
                continue;
            }
            remaining.add(i);
        }
        return remaining;
    }
}
