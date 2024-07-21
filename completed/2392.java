import java.util.*;

class Solution {
    private List<Integer> topologicalSort(int k, int[][] conditions) {
        int[] indegrees = new int[k];
        Map<Integer, List<Integer>> children = new HashMap<>();

        for (int[] condition : conditions) {
            int parent = condition[0] - 1;
            int child = condition[1] - 1;
            indegrees[child]++;
            children.computeIfAbsent(parent, _ -> new ArrayList<>());
            children.get(parent).add(child);
        }

        Queue<Integer> nodes = new LinkedList<>();
        boolean[] visited = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (indegrees[i] == 0) {
                visited[i] = true;
                nodes.add(i);
            }
        }
        List<Integer> order = new ArrayList<>();
        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            order.add(current);
            if (children.containsKey(current)) {
                for (int child : children.get(current)) {
                    indegrees[child]--;
                }
            }
            for (int i = 0; i < k; i++) {
                if (!visited[i] && indegrees[i] == 0) {
                    visited[i] = true;
                    nodes.add(i);
                }
            }
        }
        if (order.size() != k) {
            return new ArrayList<>();
        } else {
            return order;
        }
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        List<Integer> rowOrder = topologicalSort(k, rowConditions);
        List<Integer> colOrder = topologicalSort(k, colConditions);
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }

        int[][] matrix = new int[k][k];
        for (int i = 0; i < k; i++) {
            int current = rowOrder.get(i);
            for (int j = 0; j < k; j++) {
                if (colOrder.get(j) == current) {
                    matrix[i][j] = current + 1;
                    break;
                }
            }
        }
        return matrix;
    }
}
