import java.util.*;
import java.util.stream.*;

class Solution {
    private long trace(int i, int j, List<Integer> robots, List<Integer> positions, long[][] dp) {
        if (i == robots.size()) {
            return 0;
        }
        if (j == positions.size()) {
            return (long) 1e16;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // use current factory
        long use = trace(i + 1, j + 1, robots, positions, dp) + Math.abs(robots.get(i) - positions.get(j));

        // don't use current factory
        long skip = trace(i, j + 1, robots, positions, dp);

        dp[i][j] = Math.min(use, skip);
        return dp[i][j];
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        List<Integer> robots = robot.stream()
            .sorted()
            .collect(Collectors.toList());
        List<Integer> positions = Arrays.stream(factory)
            .flatMap((f) -> Stream.generate(() -> f[0]).limit(f[1]))
            .sorted()
            .collect(Collectors.toList());

        long[][] dp = new long[robots.size()][positions.size()];
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }
        return trace(0, 0, robots, positions, dp);
    }
}
