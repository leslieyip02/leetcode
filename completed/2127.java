import java.util.*;

class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] indegrees = new int[n];
        for (int i = 0; i < n; i++) {
            indegrees[favorite[i]]++;
        }

        int[] depths = new int[n];
        Arrays.fill(depths, 1);

        Queue<Integer> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                nodes.add(i);
            }
        }
        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            int next = favorite[current];
            depths[next] = Math.max(depths[current] + 1, depths[next]);
            indegrees[next]--;
            if (indegrees[next] == 0) {
                nodes.add(next);
            }
        }

        int maxCycleLength = 0;
        int combined = 0;
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                continue;
            }

            int current = i;
            int cycleLength = 0;
            while (indegrees[current] != 0) {
                indegrees[current] = 0;
                current = favorite[current];
                cycleLength++;
            }

            if (cycleLength == 2) {
                combined += depths[current] + depths[favorite[current]];
            } else {
                maxCycleLength = Math.max(cycleLength, maxCycleLength);
            }
        }
        return Math.max(maxCycleLength, combined);
    }
}
