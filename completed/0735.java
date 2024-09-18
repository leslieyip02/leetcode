import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> intact = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                intact.push(asteroid);
            } else {
                boolean shouldAdd = true;
                while (!intact.empty()) {
                    if (intact.peek() < 0) {
                        intact.push(asteroid);
                        shouldAdd = false;
                        break;
                    }

                    if (-asteroid == intact.peek()) {
                        intact.pop();
                        shouldAdd = false;
                        break;
                    }

                    if (-asteroid > intact.peek()) {
                        intact.pop();
                    } else {
                        shouldAdd = false;
                        break;
                    }
                }
                if (shouldAdd) {
                    intact.push(asteroid);
                }
            }
        }
        int[] result = new int[intact.size()];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = intact.pop();
        }
        return result;
    }
}
