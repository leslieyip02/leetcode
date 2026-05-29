class Solution {
    private Set<Integer> getSides(int max, int[] fences) {
        List<Integer> sorted = Arrays.stream(fences)
            .boxed()
            .collect(Collectors.toList());
        sorted.add(1);
        sorted.add(max);
        Collections.sort(sorted);

        // double for loop since length is <= 600
        Set<Integer> sides = new HashSet<>();
        for (int f1 : sorted) {
            for (int f2 : sorted) {
                sides.add(Math.abs(f2 - f1));
            }
        }
        sides.remove(0);
        return sides;
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> horizontal = getSides(m, hFences);
        Set<Integer> vertical = getSides(n, vFences);

        long max = -1;
        for (int side : horizontal) {
            if (vertical.contains(side)) {
                max = (long) Math.max(side, max);
            }
        }

        if (max == -1) {
            return -1;
        }
        return (int) ((max * max) % ((int) 1e9 + 7));
    }
}
