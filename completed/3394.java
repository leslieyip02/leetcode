class Solution {
    private class Bound implements Comparable<Bound> {
        int left;
        int right;

        Bound(int left, int right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Bound other) {
            return left - other.left;
        }
    }

    private boolean isValid(int n, PriorityQueue<Bound> bounds) {
        int right = bounds.poll().right;
        int dividers = 0;
        while (!bounds.isEmpty()) {
            Bound bound = bounds.poll();
            if (bound.left >= right) {
                dividers++;
            }
            right = Math.max(bound.right, right);
        }
        return dividers >= 2;
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        PriorityQueue<Bound> horizontalBounds = new PriorityQueue<>();
        PriorityQueue<Bound> verticalBounds = new PriorityQueue<>();
        for (int[] rectangle : rectangles) {
            horizontalBounds.add(new Bound(rectangle[0], rectangle[2]));
            verticalBounds.add(new Bound(rectangle[1], rectangle[3]));
        }
        return isValid(n, horizontalBounds) || isValid(n, verticalBounds);
    }
}
