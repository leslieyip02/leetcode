import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> outEdges = new HashMap<>();
        Map<Integer, Integer> inDegrees = new HashMap<>();
        for (int[] pair : pairs) {
            int start = pair[0];
            int end = pair[1];
            if (!outEdges.containsKey(start)) {
                outEdges.put(start, new ArrayList<>());
            }
            outEdges.get(start).add(end);
            inDegrees.put(end, inDegrees.getOrDefault(end, 0) + 1);
        }

        // in a directed graph with an eulerian path,
        // the start node has out-degree 1 greater than in-degree,
        // the end node has out-degree 1 fewer than in-degree,
        // and all other nodes have in-degree == out-degree
        int start = pairs[0][0];
        for (int vertex : outEdges.keySet()) {
            int outDegree = outEdges.get(vertex).size();
            if (outDegree - 1 == inDegrees.getOrDefault(vertex, 0)) {
                start = vertex;
                break;
            }
        }

        Stack<Integer> vertices = new Stack<>();
        vertices.push(start);

        Stack<Integer> ordered = new Stack<>();
        while (!vertices.empty()) {
            int current = vertices.peek();
            if (!outEdges.containsKey(current) || outEdges.get(current).isEmpty()) {
                ordered.push(current);
                vertices.pop();
                continue;
            }

            int next = outEdges.get(current).remove(0);
            vertices.push(next);
        }

        int[][] arrangement = new int[pairs.length][2];
        for (int i = 0; i < pairs.length; i++) {
            arrangement[i][0] = ordered.pop();
            arrangement[i][1] = ordered.peek();
        }
        return arrangement;
    }
}
