/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<NestedInteger> nestedList;
    private List<Integer> indices;
    private Stack<List<NestedInteger>> nestedLists;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.indices = new ArrayList<>();
        this.nestedLists = new Stack<>();

        this.indices.add(-1);
        this.nestedLists.push(this.nestedList);
        this.advance();
    }

    private void advance() {
        int nextIndex = this.indices.get(this.indices.size() - 1) + 1;
        while (!this.nestedLists.isEmpty() && nextIndex >= this.nestedLists.peek().size()) {
            this.nestedLists.pop();
            this.indices.remove(this.indices.size() - 1);
            if (this.indices.isEmpty()) {
                break;
            }
            nextIndex = this.indices.get(this.indices.size() - 1) + 1;
        }

        if (!nestedLists.isEmpty()) {
            this.indices.set(this.indices.size() - 1, nextIndex);
            int currentIndex = this.indices.get(this.indices.size() - 1);
            List<NestedInteger> currentList = nestedLists.peek();
            while (!currentList.isEmpty() && !currentList.get(currentIndex).isInteger()) {
                currentList = currentList.get(currentIndex).getList();
                this.nestedLists.push(currentList);
                this.indices.add(0);
                currentIndex = this.indices.get(this.indices.size() - 1);
            }
            if (currentList.isEmpty()) {
                this.advance();
            }
        }
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            return null;
        }

        int lastIndex = this.indices.get(this.indices.size() - 1);
        NestedInteger current = nestedLists.peek().get(lastIndex);
        this.advance();
        return current.getInteger();
    }

    @Override
    public boolean hasNext() {
        return !this.indices.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
