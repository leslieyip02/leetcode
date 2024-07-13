import java.util.*;

class Solution {
    private class Robot {
        int index;
        int position;
        int health;
        boolean left;

        public Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.left = direction == 'L';
        }
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Robot[] line = new Robot[n];
        for (int i = 0; i < positions.length; i++) {
            line[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));
        }
        Arrays.sort(line, (a, b) -> a.position - b.position);

        List<Robot> survivors = new ArrayList<>();
        Stack<Robot> lefts = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (line[i].left) {
                lefts.push(line[i]);
                continue;
            }

            boolean dead = false;
            while (!dead && !lefts.empty()) {
                Robot leftmost = lefts.peek();
                if (leftmost.health > line[i].health) {
                    leftmost.health--;
                    dead = true;
                } else if (leftmost.health < line[i].health) {
                    lefts.pop();
                    line[i].health--;
                } else {
                    lefts.pop();
                    dead = true;
                }
            }

            if (!dead && lefts.empty()) {
                survivors.add(line[i]);
            }
        }

        while (!lefts.empty()) {
            survivors.add(lefts.pop());
        }

        survivors.sort((a, b) -> a.index - b.index);
        List<Integer> result = new ArrayList<>();
        for (Robot survivor : survivors) {
            result.add(survivor.health);
        }
        return result;
    }
}
