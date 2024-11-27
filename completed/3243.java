import java.util.*;

class Solution {
    private static final int INF = 1000;

    private int shortestDistance(int n, List<List<Integer>> adjacents) {
        int[] distances = new int[n];
        boolean[] isVisited = new boolean[n];
        Arrays.fill(distances, INF);
        distances[0] = 0;

        int current = 0;
        while (current != n - 1) {
            for (int adjacent : adjacents.get(current)) {
                if (distances[current] + 1 < distances[adjacent]) {
                    distances[adjacent] = distances[current] + 1;
                }
            }

            isVisited[current] = true;
            current = -1;
            for (int i = 1; i < n; i++) {
                if (isVisited[i]) {
                    continue;
                }
                if (current == -1 || distances[i] < distances[current]) {
                    current = i;
                }
            }
        }
        return distances[n - 1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> adjacents = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            adjacents.add(new ArrayList<>());
            adjacents.get(i).add(i + 1);
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            adjacents.get(u).add(v);
            answer[i] = shortestDistance(n, adjacents);
        }
        return answer;
    }
}
