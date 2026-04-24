class SmallestInfiniteSet {

    int smallest;
    PriorityQueue<Integer> added;

    public SmallestInfiniteSet() {
        smallest = 1;
        added = new PriorityQueue<>();
    }
    
    public int popSmallest() {
        if (!added.isEmpty()) {
            return added.poll();
        }
        return smallest++;
    }

    public void addBack(int num) {
        if (num < smallest && !added.contains(num)) {
            added.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */
