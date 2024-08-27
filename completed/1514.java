import java.util.*;

class Solution {
    private static class Weight implements Comparable<Weight> {
        public int vertex;
        public double weight;

        public Weight(int vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Weight other) {
            return Double.compare(other.weight, this.weight);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double[] probabilities = new double[n];
        Arrays.fill(probabilities, 0.0);
        probabilities[start_node] = 1.0;

        List<List<Weight>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(i, new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            adjacencyList.get(a).add(new Weight(b, succProb[i]));
            adjacencyList.get(b).add(new Weight(a, succProb[i]));
        }

        PriorityQueue<Weight> pq = new PriorityQueue<>();
        pq.add(new Weight(start_node, 1.0));
        while (!pq.isEmpty()) {
            Weight current = pq.poll();
            List<Weight> adjacents = adjacencyList.get(current.vertex);
            for (Weight adjacent : adjacents) {
                double newProbability = probabilities[current.vertex] * adjacent.weight;
                if (newProbability > probabilities[adjacent.vertex]) {
                    probabilities[adjacent.vertex] = newProbability;
                    pq.add(new Weight(adjacent.vertex, newProbability));
                }
            }
        }
        return probabilities[end_node];
    }
}
