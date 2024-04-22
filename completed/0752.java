import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        if (target.compareTo("0000") == 0) {
            return 0;
        }

        Set<Integer> blocked = new HashSet<>();
        for (String deadend : deadends) {
            if (deadend.compareTo("0000") == 0) {
                return -1;
            }
            blocked.add(Integer.parseInt(deadend));
        }

        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(0);

        int[] distances = new int[10000];
        Arrays.fill(distances, -1);
        distances[0] = 0;

        int goal = Integer.parseInt(target);
        while (!nodes.isEmpty()) {
            int current = nodes.poll();
            for (int i = 0; i < 4; i++) {
                int x = (int) Math.pow(10, i);
                int y = (int) Math.pow(10, i + 1);

                int left = current / y * y;
                int right = current % x;
                int digit = (current % y - current % x) / x;

                int below = left + ((digit + 9) % 10) * x + right;
                if (!blocked.contains(below) && distances[below] == -1) {
                    distances[below] = distances[current] + 1;
                    if (below == goal) {
                        return distances[below];
                    }
                    nodes.add(below);
                }

                int above = left + ((digit + 1) % 10) * x + right;
                if (!blocked.contains(above) && distances[above] == -1) {
                    distances[above] = distances[current] + 1;
                    if (above == goal) {
                        return distances[above];
                    }
                    nodes.add(above);
                }
            }
        }
        return -1;
    }
}
