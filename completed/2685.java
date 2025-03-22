class Solution {
    private void visit(int current, List<Integer> component, List<Set<Integer>> adjacencyLists, boolean[] visited) {
        component.add(current);
        visited[current] = true;
        for (int adjacent : adjacencyLists.get(current)) {
            if (visited[adjacent]) {
                continue;
            }
            visit(adjacent, component, adjacencyLists, visited);
        }
    }

    private boolean ok(List<Integer> component, List<Set<Integer>> adjacencyLists) {
        for (int i : component) {
            for (int j : component) {
                if (i != j && !adjacencyLists.get(i).contains(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<Set<Integer>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new HashSet<>());
        }

        for (int[] edge : edges) {
            adjacencyLists.get(edge[0]).add(edge[1]);
            adjacencyLists.get(edge[1]).add(edge[0]);
        }

        List<List<Integer>> components = new ArrayList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }

            List<Integer> component = new ArrayList<>();
            visit(i, component, adjacencyLists, visited);
            components.add(component);
        }

        int count = 0;
        for (List<Integer> component : components) {
            if (ok(component, adjacencyLists)) {
                count++;
            }
        }
        return count;
    }
}
