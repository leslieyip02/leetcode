class Solution {

    private Integer getAvailableServer(int i, int k, TreeSet<Integer> availableServers) {
        if (availableServers.isEmpty()) {
            return null;
        }

        Integer targetServer = availableServers.ceiling(i % k);
        if (targetServer == null) {
            // wrapped around
            // it's ok to call .first() since availableServers isn't empty
            targetServer = availableServers.first();
        }
        return targetServer;
    }

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] requestsHandledCount = new int[k];

        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i);
        }

        // Integer[] is { completionTime, server }
        PriorityQueue<Integer[]> inProgressJobs = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        for (int i = 0; i < arrival.length; i++) {
            // free up servers that have finished their jobs
            while (!inProgressJobs.isEmpty()) {
                int completionTime = inProgressJobs.peek()[0];
                if (completionTime <= arrival[i]) {
                    int server = inProgressJobs.poll()[1];
                    availableServers.add(server);
                } else {
                    break;
                }
            }

            Integer targetServer = getAvailableServer(i, k, availableServers);
            if (targetServer == null) {
                // none are available -> skip the job
                continue;
            }

            availableServers.remove(targetServer);
            inProgressJobs.add(new Integer[]{ arrival[i] + load[i], targetServer });
            requestsHandledCount[targetServer]++;
        }

        List<Integer> busiest = new ArrayList<>(List.of(0));
        for (int i = 1; i < k; i++) {
            int count = requestsHandledCount[busiest.get(0)];
            if (requestsHandledCount[i] > count) {
                busiest = new ArrayList<>(List.of(i));
            } else if (requestsHandledCount[i] == count) {
                busiest.add(i);
            }
        }
        return busiest;
    }
}
