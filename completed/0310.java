import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            ArrayList<Integer> result = new ArrayList<>();
            result.add(0);
            return result;
        }

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            graph.get(i).add(j);
            graph.get(j).add(i);
            indegree[i]++;
            indegree[j]++;
        }

        Queue<Integer> leaves = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                leaves.add(i);
            }
        }

        // reduce leaf nodes with only 1 neighbour
        // until the middle of the longest path is reached
        ArrayList<Integer> result = new ArrayList<>();
        while (!leaves.isEmpty()) {
            int count = leaves.size();
            result.clear();
            for (; count > 0; count--) {
                int root = leaves.poll();
                result.add(root);

                for (int adjacent : graph.get(root)) {
                    indegree[adjacent]--;
                    if (indegree[adjacent] == 1) {
                        leaves.add(adjacent);
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        // int[][] edges = { { 3, 0 }, { 3, 1 }, { 3, 2 }, { 3, 4 }, { 5, 4 } };
        // int[][] edges = { { 0, 1 }, { 0, 2 } };

        Solution solution = new Solution();
        List<Integer> result = solution.findMinHeightTrees(n, edges);
        for (int root : result) {
            System.out.println(root);
        }
    }
}
