import java.util.*;

class Solution {
    private int[] clearedCourses;

    private int clearCourse(int current, HashMap<Integer, HashSet<Integer>> graph, int[] time) {
        if (this.clearedCourses[current] != -1) {
            return this.clearedCourses[current];
        }

        int maximum = 0;
        HashSet<Integer> prerequisites = graph.get(current);
        if (prerequisites != null) {
            for (int prerequisite : graph.get(current)) {
                maximum = Math.max(this.clearCourse(prerequisite, graph, time), maximum);
            }
        }

        this.clearedCourses[current] = maximum + time[current];
        return this.clearedCourses[current];
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        if (relations.length == 0) {
            int maximum = 0;
            for (int current : time) {
                maximum = Math.max(current, maximum);
            }
            return maximum;
        }

        this.clearedCourses = new int[n];
        Arrays.fill(clearedCourses, -1);

        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        HashSet<Integer> children = new HashSet<>();
        for (var relation : relations) {
            int p = relation[0] - 1;
            int q = relation[1] - 1;
            if (!graph.containsKey(q)) {
                graph.put(q, new HashSet<>());
            }
            graph.get(q).add(p);
            children.add(p);
        }

        int courses = 0;
        for (int i = 0; i < n; i++) {
            if (!children.contains(i)) {
                courses = Math.max(this.clearCourse(i, graph, time), courses);
            }
        }
        return courses;
    }

    public static void main(String[] args) {
        /*
        int n = 3;
        int[][] relations = { { 1, 3 }, { 2, 3 } };
        int[] time = { 3, 2, 5 };
        int n = 5;
        int[][] relations = { { 1, 5 }, { 2, 5 }, { 3, 5 }, { 3, 4 }, { 4, 5 } };
        int[] time = { 1, 2, 3, 4, 5 };
        */
        int n = 9;
        int[][] relations = { { 2, 7 }, { 2, 6 }, { 3, 6 }, { 4, 6 }, { 7, 6 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 6, 1 }, { 7, 1 }, { 3, 8 }, { 5, 8 }, { 7, 8 }, { 1, 9 }, { 2, 9 }, { 6, 9 }, { 7, 9 } };
        int[] time = { 9, 5, 9, 5, 8, 7, 7, 8, 4 };

        Solution solution = new Solution();
        System.out.println(solution.minimumTime(n, relations, time));
    }
}
