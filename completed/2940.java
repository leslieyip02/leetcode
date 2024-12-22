import java.util.*;

class Solution {
    private record Pair(int first, int second) {}

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);

        List<List<Pair>> unresolved = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            unresolved.add(new ArrayList<>());
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int tmp = a;
                a = b;
                b = tmp;
            }

            if (a == b || heights[a] < heights[b]) {
                ans[i] = b;
                continue;
            }

            unresolved.get(b).add(new Pair(i, a));
        }

        List<Integer> monotonicStack = new ArrayList<>();
        for (int j = heights.length - 1; j >= 0; j--) {
            int size = monotonicStack.size();
            for (Pair pair : unresolved.get(j)) {
                int i = pair.first();
                int a = pair.second();

                int left = 0;
                int right = size - 1;
                int k = -1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (heights[monotonicStack.get(mid)] > heights[a]) {
                        k = Math.max(mid, k);
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

                if (k < size && k >= 0) {
                    ans[i] = monotonicStack.get(k);
                }
            }

            if (size != 0) {
                int last = monotonicStack.get(size - 1);
                while (heights[last] <= heights[j]) {
                    monotonicStack.remove(size - 1);
                    if (monotonicStack.isEmpty()) {
                        break;
                    }
                    size--;
                    last = monotonicStack.get(size - 1);
                }
            }
            monotonicStack.add(j);
        }

        return ans;
    }
}
