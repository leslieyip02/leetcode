import java.util.*;

class Solution {
    private void visit(int current, List<List<Integer>> adjacencyLists, boolean[] visited) {
        visited[current] = true;
        for (int adjacent : adjacencyLists.get(current)) {
            if (!visited[adjacent]) {
                visit(adjacent, adjacencyLists, visited);
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;
        List<List<Integer>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (stones[i][0] == stones[j][0] ||
                    stones[i][1] == stones[j][1]) {
                    adjacencyLists.get(i).add(j);
                    adjacencyLists.get(j).add(i);
                }
            }
        }

        int components = 0;
        boolean[] visited = new boolean[stones.length];
        for (int i = 0; i < stones.length; i++) {
            if (visited[i]) {
                continue;
            }

            visit(i, adjacencyLists, visited);
            components++;
        }
        return stones.length - components;
    } 
}
