import java.util.*;

class Solution {
    private static final int[][] DIRECTIONS = {{ 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }};

    public int robotSim(int[] commands, int[][] obstacles) {
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();
        boolean isOriginBlocked = false;
        for (int[] obstacle : obstacles) {
            int xi = obstacle[0];
            int yi = obstacle[1];
            if (xi == 0 && yi == 0) {
                isOriginBlocked = true;
                continue;
            }
            rows.computeIfAbsent(yi, _ -> new TreeSet<>()).add(xi);
            cols.computeIfAbsent(xi, _ -> new TreeSet<>()).add(yi);
        }

        int x = 0;
        int y = 0;
        int directionIndex = 0;
        int maxEuclideanDistance = 0;
        for (int command : commands) {
            if ((x != 0 || y != 0) && isOriginBlocked) {
                rows.computeIfAbsent(0, _ -> new TreeSet<>()).add(0);
                cols.computeIfAbsent(0, _ -> new TreeSet<>()).add(0);
                isOriginBlocked = false;
            }
            if (command < 0) {
                directionIndex = command == -1
                    ? (directionIndex + 1) % DIRECTIONS.length
                    : (directionIndex - 1 + DIRECTIONS.length) % DIRECTIONS.length;
                continue;
            }

            int[] direction = DIRECTIONS[directionIndex];
            if (direction[0] != 0) {
                int x1 = x + direction[0] * command;
                if (!rows.containsKey(y)) {
                    x = x1;
                } else if (direction[0] == 1) {
                    Integer bound = rows.get(y).ceiling(x);
                    x = bound == null ? x1 : Math.min(x1, bound - 1);
                } else {
                    Integer bound = rows.get(y).floor(x);
                    x = bound == null ? x1 : Math.max(x1, bound + 1);
                }
            } else {
                int y1 = y + direction[1] * command;
                if (!cols.containsKey(x)) {
                    y = y1;
                } else if (direction[1] == 1) {
                    Integer bound = cols.get(x).ceiling(y);
                    y = bound == null ? y1 : Math.min(y1, bound - 1);
                } else {
                    Integer bound = cols.get(x).floor(y);
                    y = bound == null ? y1 : Math.max(y1, bound + 1);
                }
            }
            maxEuclideanDistance = Math.max(x * x + y * y, maxEuclideanDistance);
        }
        return maxEuclideanDistance;
    }
}
