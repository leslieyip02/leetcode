import java.util.*;

class RandomizedSet {

    private final List<Integer> values;
    private final Map<Integer, Integer> indices;
    private int size;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.indices = new HashMap<>();
        this.size = 0;
    }
    
    public boolean insert(int val) {
        if (this.indices.containsKey(val)) {
            return false;
        }

        if (size < this.values.size()) {
            this.values.set(this.size, val);
        } else {
            this.values.add(val);
        }
        this.indices.put(val, this.size);
        this.size++;
        return true;
    }
    
    public boolean remove(int val) {
        if (!this.indices.containsKey(val)) {
            return false;
        }

        int index = this.indices.get(val);
        int newValue = this.values.get(this.size - 1);
        this.values.set(index, newValue);
        this.indices.put(newValue, index);
        this.indices.remove(val);
        this.size--;
        return true;
    }
    
    public int getRandom() {
        int index = (int) (Math.random() * size);
        return this.values.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
