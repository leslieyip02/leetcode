import java.util.*;

class NumberContainers {

    Map<Integer, Integer> numbers;
    Map<Integer, SortedSet<Integer>> indices;

    public NumberContainers() {
        this.numbers = new HashMap<>();
        this.indices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (numbers.containsKey(index)) {
            int originalNumber = numbers.get(index);
            indices.get(originalNumber).remove(index);

        }

        numbers.put(index, number);
        if (!indices.containsKey(number)) {
            indices.put(number, new TreeSet<>());
        }
        indices.get(number).add(index);
    }

    public int find(int number) {
        return indices.containsKey(number) && !indices.get(number).isEmpty() ? indices.get(number).first() : -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */
