import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> uniques = new HashSet<>();
        for (var point : points) {
            uniques.add(point[0]);
        }

        Integer[] values = uniques.toArray(new Integer[0]);
        Arrays.sort(values);
        int largest = 0;
        for (int i = 1; i < values.length; i++) {
            largest = Math.max(values[i] - values[i - 1], largest);
        }
        return largest;
    }
}
