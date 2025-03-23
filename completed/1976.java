class Solution {
    private static final int MOD = (int) 1e9 + 7;

    class Node implements Comparable<Node> {
        int index;
        long time;

        Node(int index, long time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(time, other.time);
        }
    }

    public int countPaths(int n, int[][] roads) {
        List<Map<Integer, Integer>> adjacencyLists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyLists.add(new HashMap<>());
        }
        for (int road[] : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            adjacencyLists.get(u).put(v, w);
            adjacencyLists.get(v).put(u, w);
        }

        long[] times = new long[n];
        Arrays.fill(times, Long.MAX_VALUE);
        times[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;

        PriorityQueue<Node> nodes = new PriorityQueue<>();
        nodes.add(new Node(0, 0));
        while (!nodes.isEmpty()) {
            Node current = nodes.poll();
            if (current.time > times[current.index]) {
                continue;
            }

            for (Map.Entry<Integer, Integer> entry : adjacencyLists.get(current.index).entrySet()) {
                long time = current.time + entry.getValue();
                if (time < times[entry.getKey()]) {
                    times[entry.getKey()] = time;
                    ways[entry.getKey()] = ways[current.index];
                    nodes.add(new Node(entry.getKey(), time));
                } else if (time == times[entry.getKey()]) {
                    ways[entry.getKey()] = (ways[entry.getKey()] + ways[current.index]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}
