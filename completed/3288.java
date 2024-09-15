import java.util.*;

class Solution {
    private class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            return this.x == other.x
                ? other.y - this.y
                : this.x - other.x;
        }
    }

    private int longestIncreasing(int start, int end, int k, Point[] points) {
        int maximumLength = end - start + 1;
        if (maximumLength <= 0) {
            return 0;
        }
        int[] lastIndices = new int[maximumLength];

        int longest = 0;
        for (int i = start; i < end; i++) {
            if (points[i].x <= points[k].x ||
                points[i].y <= points[k].y) {
                continue;
            }

            int lower = 1;
            int upper = longest + 1;
            while (lower < upper) {
                int mid = (lower + upper) / 2;
                if (points[lastIndices[mid]].x >= points[i].x ||
                    points[lastIndices[mid]].y >= points[i].y) {
                    upper = mid;
                } else {
                    lower = mid + 1;
                }
            }
            lastIndices[lower] = i;
            longest = Math.max(lower, longest);
        }
        return longest;
    }

    private int longestDecreasing(int start, int end, int k, Point[] points) {
        int maximumLength = start - end + 1;
        if (maximumLength <= 0) {
            return 0;
        }
        int[] lastIndices = new int[maximumLength];

        int longest = 0;
        for (int i = start; i > end; i--) {
            if (points[i].x >= points[k].x ||
                points[i].y >= points[k].y) {
                continue;
            }

            int lower = 1;
            int upper = longest + 1;
            while (lower < upper) {
                int mid = (lower + upper) / 2;
                if (points[lastIndices[mid]].x <= points[i].x ||
                    points[lastIndices[mid]].y <= points[i].y) {
                    upper = mid;
                } else {
                    lower = mid + 1;
                }
            }
            lastIndices[lower] = i;
            longest = Math.max(lower, longest);
        }
        return longest;
    }

    public int maxPathLength(int[][] coordinates, int k) {
        Point[] points = new Point[coordinates.length];
        for (int i = 0; i < coordinates.length; i++) {
            points[i] = new Point(coordinates[i][0], coordinates[i][1]);
        }
        Point target = points[k];
        Arrays.sort(points);

        for (int i = 0; i < points.length; i++) {
            if (points[i] == target) {
                k = i;
                break;
            }
        }

        int maximumPrefixPath = longestDecreasing(k - 1, -1, k, points);
        int maximumSuffixPath = longestIncreasing(k + 1, points.length, k, points);
        return maximumPrefixPath + 1 + maximumSuffixPath;
    }
}
