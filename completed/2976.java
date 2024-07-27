import java.util.*;

class Solution {
    private static final long INF = (long) Long.MAX_VALUE;
    private static final int N = 26;
    private static final int IMPOSSIBLE = -1;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(graph[i], INF);
        }
        for (int i = 0; i < original.length; i++) {
            int from = (int) original[i] - 97;
            int to = (int) changed[i] - 97;
            graph[from][to] = Math.min(cost[i], graph[from][to]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (graph[j][i] == INF || graph[i][k] == INF) {
                        continue;
                    } 

                    if (graph[j][i] + graph[i][k] < graph[j][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }

        long result = 0;
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == target.charAt(i)) {
                continue;
            }

            int from = (int) source.charAt(i) - 97;
            int to = (int) target.charAt(i) - 97;
            if (graph[from][to] == INF) {
                return IMPOSSIBLE;
            }
            result += graph[from][to];
        }
        return result;
    }
}
