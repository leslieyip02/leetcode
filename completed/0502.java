import java.util.*;

class Solution {
    private class Project implements Comparable<Project> {
        public int profit;
        public int capital;

        public Project(int profit, int capital) {
            this.profit = profit;
            this.capital = capital;
        }

        @Override
        public int compareTo(Project other) {
            return this.capital - other.capital;
        }
    }

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<Integer> kiv = new PriorityQueue<>((a, b) -> b - a);

        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(profits[i], capital[i]);
        }
        Arrays.sort(projects);

        int i = 0;
        while (k > 0) {
            while (i < n && w >= projects[i].capital) {
                kiv.add(projects[i].profit);
                i++;
            }
            if (kiv.isEmpty()) {
                break;
            } else {
                w += kiv.poll();
            }
            k--;
        }

        return w;
    }
}
