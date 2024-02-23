class Solution {
    class Flight {
        int from;
        int to;
        int cost;
        int stops;

        Flight(int from, int to, int cost, int stops) {
            this.from = from;
            this.to = to;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Map<Integer, Integer>> costs = new HashMap<>();
        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int cost = flights[i][2];
            if (!costs.containsKey(from)) {
                costs.put(from, new HashMap<>());
            }
            costs.get(from).put(to, cost);
        }

        Map<Integer, Integer> cheapest = new HashMap<>();
        cheapest.put(src, 0);

        Queue<Flight> queue = new LinkedList<>();
        queue.add(new Flight(src, src, 0, 0));
        while (!queue.isEmpty()) {
            Flight flight = queue.poll();
            if (flight.to == dst) {
                if (flight.cost < cheapest.getOrDefault(dst, Integer.MAX_VALUE)) {
                    cheapest.put(dst, flight.cost);
                }
                continue;
            }

            Map<Integer, Integer> connected = costs.get(flight.to);
            if (connected != null && flight.stops <= k) {
                for (Map.Entry<Integer, Integer> entry : connected.entrySet()) {
                    int next = entry.getKey();
                    int cost = flight.cost + entry.getValue();
                    if (cost < cheapest.getOrDefault(next, Integer.MAX_VALUE)) {
                        cheapest.put(next, cost);
                        queue.add(new Flight(flight.to, next, cost, flight.stops + 1));
                    }
                }
            }
        }
        return cheapest.getOrDefault(dst, -1);
    }
}
