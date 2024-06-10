import java.util.*;

class Solution {
    private class Garden implements Comparable<Garden> {
        int flower;
        int degree;
        int banned;
        List<Garden> adjacents;

        public Garden() {
            this.flower;
            this.degree = 0;
            this.banned = 0;
            this.adjacents = new ArrayList<>();
        }

        public void addAdjacent(Garden other) {
            this.adjacents.add(other);
            this.degree++;
        }

        public void chooseFlower() {
            int flower = 0;
            while (((1 << flower) & this.banned) != 0) {
                flower++;
            }
            this.flower = flower + 1;
            for (Garden adjacent : this.adjacents) {
                adjacent.banned |= (1 << flower);
            }
        }

        @Override
        public int compareTo(Garden other) {
            return other.degree - this.degree;
        }
    }

    public int[] gardenNoAdj(int n, int[][] paths) {
        Garden[] gardens = new Garden[n];
        for (int i = 0; i < n; i++) {
            gardens[i] = new Garden();
        }

        for (int[] path : paths) {
            int x = path[0] - 1;
            int y = path[1] - 1;
            gardens[x].addAdjacent(gardens[y]);
            gardens[y].addAdjacent(gardens[x]);
        }

        PriorityQueue<Garden> greatestDegree = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            greatestDegree.add(gardens[i]);
        }
        while (!greatestDegree.isEmpty()) {
            Garden current = greatestDegree.poll();
            current.chooseFlower();
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = gardens[i].flower;
        }
        return result;
    }
}
