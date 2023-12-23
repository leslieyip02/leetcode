import java.util.*;

class Solution {
    public boolean isPathCrossing(String path) {
        int x = 0;
        int y = 0;
        Set<AbstractMap.SimpleEntry<Integer, Integer>> points = new HashSet<>();
        points.add(new AbstractMap.SimpleEntry(x, y));
        for (int i = 0; i < path.length(); i++) {
            switch (path.charAt(i)) {
                case 'N':
                    y += 1;
                    break;
                case 'S':
                    y -= 1;
                    break;
                case 'E':
                    x += 1;
                    break;
                case 'W':
                    x -= 1;
                    break;
            }
            var point = new AbstractMap.SimpleEntry(x, y);
            if (points.contains(point)) {
                return true;
            }
            points.add(point);
        }
        return false;
    }
}
