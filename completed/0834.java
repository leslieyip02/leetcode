import java.util.*;

class Solution {
    private static final int INF = (int) 1e9;

    private int getSubtreeSizes(int index, List<List<Integer>> adjacents, int[] subtreeSizes) {
        boolean leaf = true;
        subtreeSizes[index] = 1;
        for (int adjacent : adjacents.get(index)) {
            if (subtreeSizes[adjacent] == 0) {
                subtreeSizes[index] += getSubtreeSizes(adjacent, adjacents, subtreeSizes);
                leaf = false;
            }
        }

        if (leaf) {
            subtreeSizes[index] = 1;
        }
        return subtreeSizes[index];
    }

    private void getSubtreeSums(int index, List<List<Integer>> adjacents, int[] subtreeSizes, int[] subtreeSums) {
        int current = subtreeSums[index];
        int n = adjacents.size();
        for (int adjacent : adjacents.get(index)) {
            if (subtreeSums[adjacent] == 0) {
                subtreeSums[adjacent] = current + (n - subtreeSizes[adjacent]) - subtreeSizes[adjacent];
                getSubtreeSums(adjacent, adjacents, subtreeSizes, subtreeSums);
            }
        }
    }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacents.add(new ArrayList<>());
        }
        for (var edge : edges) {
            int src = edge[0];
            int dst = edge[1];
            adjacents.get(src).add(dst);
            adjacents.get(dst).add(src);
        }

        // get the subsizes of each subtreee
        int root = 0;
        int[] subtreeSizes = new int[n];
        getSubtreeSizes(root, adjacents, subtreeSizes);

        // use BFS to find sum for root
        int[] distancesToRoot = new int[n];
        Arrays.fill(distancesToRoot, INF);
        distancesToRoot[root] = 0;
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(root);
        int rootSum = 0;
        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            for (int adjacent : adjacents.get(current)) {
                if (distancesToRoot[adjacent] == INF) {
                    distancesToRoot[adjacent] = distancesToRoot[current] + 1;
                    nodes.add(adjacent);
                    rootSum += distancesToRoot[adjacent];
                }
            }
        }

        // get other sums
        int[] subtreeSums = new int[n];
        subtreeSums[root] = rootSum;
        getSubtreeSums(root, adjacents, subtreeSizes, subtreeSums);

        return subtreeSums;
    }
}
