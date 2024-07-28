import java.util.*;

class Solution {
    private static final int UNVISITED = Integer.MAX_VALUE;

    private class Visit {
        int index;
        boolean firstTime;

        public Visit(int index, boolean firstTime) {
            this.index = index;
            this.firstTime = firstTime;
        }
    }

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Map<Integer, List<Integer>> adjacents = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            adjacents.computeIfAbsent(u, _ -> new ArrayList<>());
            adjacents.computeIfAbsent(v, _ -> new ArrayList<>());
            adjacents.get(u).add(v);
            adjacents.get(v).add(u);
        }

        int[][] times = new int[2][n];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(times[i], UNVISITED);
        }
        times[0][0] = 0;

        Queue<Visit> nodes = new LinkedList<>();
        nodes.add(new Visit(0, true));
        while (!nodes.isEmpty()) {
            Visit current = nodes.poll();
            int currentTime = current.firstTime ? times[0][current.index] : times[1][current.index];
            if ((currentTime / change) % 2 == 1) {
                currentTime = (currentTime / change + 1) * change;
            }
            currentTime += time;

            for (int adjacent : adjacents.get(current.index)) {
                if (times[0][adjacent] == UNVISITED) {
                    times[0][adjacent] = currentTime;
                    nodes.add(new Visit(adjacent, true));
                } else if (times[1][adjacent] == UNVISITED && times[0][adjacent] != currentTime) {
                    if (adjacent == (n - 1)) {
                        return currentTime;
                    }
                    times[1][adjacent] = currentTime;
                    nodes.add(new Visit(adjacent, false));
                }
            }
        }
        return 0;
    }
}
