class RLEIterator {

    private Deque<Integer> encoded;

    public RLEIterator(int[] encoding) {
        encoded = new ArrayDeque<>();
        for (int value : encoding) {
            encoded.addLast(value);
        }
    }
    
    public int next(int n) {
        if (encoded.isEmpty()) {
            return -1;
        }

        int count = encoded.pollFirst();
        if (count <= n) {
            int previous = encoded.pollFirst();
            return count == n ? previous : next(n - count);
        }

        int exhausted = encoded.peekFirst();
        encoded.addFirst(count - n);
        return exhausted;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
