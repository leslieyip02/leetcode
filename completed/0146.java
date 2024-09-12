import java.util.*;

class LRUCache {
    private static class Node {
        public int key;
        public int value;
        public Node previous;
        public Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> valuesMap;
    private Node head;
    private Node tail;
    private int capacity;

    public LRUCache(int capacity) {
        this.valuesMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!valuesMap.containsKey(key)) {
            return -1;
        }

        update(key);
        return valuesMap.get(key).value;
    }

    public void put(int key, int value) {
        if (valuesMap.containsKey(key)) {
            valuesMap.get(key).value = value;
            update(key);
            return;
        }

        Node node = new Node(key, value);
        valuesMap.put(key, node);
        if (head != null) {
            head.previous = node;
        }
        node.next = head;
        head = node;
        if (tail == null) {
            tail = node;
        }
        if (valuesMap.size() > capacity) {
            valuesMap.remove(tail.key);
            tail = tail.previous;
        }
    }

    private void update(int key) {
        Node current = valuesMap.get(key);
        if (current == head) {
            return;
        }

        // current.previous is not null
        current.previous.next = current.next;
        if (current == tail) {
            tail = current.previous;
        }
        if (current.next != null) {
            current.next.previous = current.previous;
        }

        // move node to front
        current.previous = null;
        if (head != null) {
            head.previous = current;
        }
        current.next = head;
        head = current;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
