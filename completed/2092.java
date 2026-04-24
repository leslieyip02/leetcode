class Solution {
    private void dfs(
        int index,
        Map<Integer, List<Integer>> adjacencyLists,
        Set<Integer> visited,
        List<Integer> component
    ) {
        // 1. Recursively construct the component
        component.add(index);
        visited.add(index);

        for (int adjacent : adjacencyLists.get(index)) {
            if (visited.contains(adjacent)) {
                // already visited
                continue;
            }

            dfs(adjacent, adjacencyLists, visited, component);
        }
    }

    private List<List<Integer>> getConnectedComponents(
        int[][] meetings,
        int left,
        int right
    ) {
        // 1. Construct adjacency lists for easy look up
        Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
        for (int i = left; i < right; i++) {
            int x = meetings[i][0];
            int y = meetings[i][1];
            adjacencyLists.computeIfAbsent(x, _ -> new ArrayList<>()).add(y);
            adjacencyLists.computeIfAbsent(y, _ -> new ArrayList<>()).add(x);
        }

        // 2. DFS from each person and construct the components
        List<List<Integer>> components = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int source : adjacencyLists.keySet()) {
            if (visited.contains(source)) {
                // already visited
                continue;
            }

            List<Integer> component = new ArrayList<>();
            dfs(source, adjacencyLists, visited, component);
            components.add(component);
        }
        return components;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        // 1. Order meetings by time
        Arrays.sort(meetings, (m1, m2) -> m1[2] - m2[2]);

        // 2. Keep track of who knows
        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

        // 3. Go through all meetings and update who knows
        int left = 0;
        while (left < meetings.length) {
            // 4. Get all meetings at the same time
            List<Integer[]> concurrentMeetings = new ArrayList<>();

            int time = meetings[left][2];
            int right = left;
            while (right < meetings.length) {
                if (meetings[right][2] > time) {
                    break;
                }
                right++;
            }

            // 5. Find the connected components
            List<List<Integer>> components = getConnectedComponents(meetings, left, right);

            // 6. Update everyone in the component if needed
            for (List<Integer> component : components) {
                boolean someoneKnows = false;
                for (int person : component) {
                    if (knows[person]) {
                        someoneKnows = true;
                        break;
                    }
                }

                if (someoneKnows) {
                    for (int person : component) {
                        knows[person] = true;
                    }
                }
            }

            left = right;
        }

        // 7. Construct result
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (knows[i]) {
                result.add(i);
            }
        }
        return result;
    }
}

